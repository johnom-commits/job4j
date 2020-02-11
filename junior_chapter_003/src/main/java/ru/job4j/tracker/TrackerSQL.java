package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;

    public TrackerSQL() {
        init();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            initTablesDB();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection != null;
    }

    private void initTablesDB() {
        try (final Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS items (id varchar(50) PRIMARY KEY, name varchar(50) NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        try (final PreparedStatement st = connection.prepareStatement("INSERT INTO items (id, name) VALUES (?, ?)", Statement.NO_GENERATED_KEYS)) {
            String uniqueID = UUID.randomUUID().toString();
            st.setString(1, uniqueID);
            st.setString(2, item.getName());
            item.setId(uniqueID);
            st.executeUpdate();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new item");
    }

    @Override
    public boolean replace(String id, Item item) {
        int result = 0;
        try (final PreparedStatement st = connection.prepareStatement("UPDATE items SET name = ? WHERE id = ?")) {
            st.setString(1, item.getName());
            st.setString(2, id);
            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (result == 1) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        int result = 0;
        try (final PreparedStatement st = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            st.setString(1, id);
            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return (result == 1) ? true : false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (final Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM items");
            String id = "";
            String name = "";
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                Item item = new Item(id, name);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (final PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            String id = "";
            while (rs.next()) {
                id = rs.getString(1);
                Item item = new Item(id, key);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (final PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                item = new Item(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}