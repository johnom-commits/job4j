package io;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenReturnFirstKey() {
        String path = Config.class.getClassLoader().getResource("app.properties").getFile();
        Config config = new Config(path);
        config.load();
        String result = config.value("hibernate.dialect");
        assertEquals("org.hibernate.dialect.PostgreSQLDialect", result);
    }

    @Test
    public void whenReturnLastKey() {
        String path = Config.class.getClassLoader().getResource("app.properties").getFile();
        Config config = new Config(path);
        config.load();
        String result = config.value("hibernate.connection.password");
        assertEquals("password", result);
    }
}