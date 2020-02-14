package ru.job4j.array;

import org.xml.sax.SAXException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config conf) {
        config = conf;
    }

    public void generate(int size) throws SQLException {
        connect.setAutoCommit(false);
        try (final PreparedStatement st = connect.prepareStatement("INSERT INTO entry (field) VALUES (?)", Statement.NO_GENERATED_KEYS)) {
            for (int i = 1; i <= size; i++) {
                st.setInt(1, i);
                st.addBatch();
            }
            st.executeBatch();
            connect.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            if (connect != null) {
                try {
                    connect.rollback();
                } catch (SQLException exp) {
                    exp.printStackTrace();
                }
            }
        }
        connect.setAutoCommit(true);
    }

    public List<Entry> load() {
        List<Entry> list = new ArrayList<>();

        try (final Statement st = connect.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT field FROM entry");
            int result;
            while (rs.next()) {
                result = rs.getInt(1);
                if (result > 0) {
                    Entry e = new Entry();
                    e.setField(result);
                    list.add(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public static void main(String[] args) throws SQLException, JAXBException, IOException, TransformerException, ParserConfigurationException, SAXException {
        StoreSQL storeSQL = new StoreSQL(new Config());
        try (Connection con = DriverManager.getConnection(storeSQL.config.get("url"))) {
            try (final Statement st = con.createStatement()) {
                String sql = "DROP TABLE IF EXISTS entry;";
                st.execute(sql);
                sql = "CREATE TABLE entry (field INTEGER PRIMARY KEY);";
                st.execute(sql);
                storeSQL.connect = con;
                storeSQL.generate(10);

                File file = new File("1.xml");
                StoreXML storeXML = new StoreXML(file);
                storeXML.save(storeSQL.load());

                ConvertXSQT convert = new ConvertXSQT();
                File fileDest = new File("2.xml");
                File schema = storeSQL.getFileFromResources("schemaXSL.xml");
                convert.convert(file, fileDest, schema);

                CountFieldFromXML count = new CountFieldFromXML();
                int result = count.count(fileDest);
                System.out.println("Total sum: " + result);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
