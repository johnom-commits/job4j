package ru.job4j.array;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public Config() {
        init();
    }

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return values.getProperty(key);
    }
}
