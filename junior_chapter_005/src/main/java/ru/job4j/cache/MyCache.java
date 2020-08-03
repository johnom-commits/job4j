package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class MyCache {
    private String dir;
    private final HashMap<String, SoftReference<String>> map = new HashMap<>();

    public MyCache(String dir) {
        this.dir = dir;
    }

    public String get(String key) {
        if (map.containsKey(key)) {
            SoftReference<String> softRef = map.get(key);
            String text = softRef.get();
            if (text == null) {
                return readFile(key);
            } else {
                return text;
            }
        }
        return readFile(key);
    }

    private String readFile(String key) {
        Path path = Path.of(dir, key);
        String text = "";
        try {
            text = Files.readString(path);
            map.put(key, new SoftReference<>(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
