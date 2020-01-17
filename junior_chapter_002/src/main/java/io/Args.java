package io;

import java.util.HashMap;
import java.util.Map;

public class Args {
    Map<String, String> mapArgs = new HashMap<>();
    private static final int LENGTH_ARGS = 6;

    public Args(String[] args) {
        parsingArgs(args);
    }

    private void parsingArgs(String[] args) {
        checkLengthArrayArgs(args);
        String key = "";
        String arg = "";
        for (int i = 0; i < args.length; i++) {
            arg = args[i];
            int mod = i % 2;
            if (mod == 0) {
                if (!arg.startsWith("-")) {
                    throw new IllegalArgumentException("Не верный ключ: " + arg);
                }
                key = arg;
            } else {
                if (arg.startsWith("-")) {
                    throw new IllegalArgumentException("Не верное значение ключа: " + arg);
                }
                mapArgs.put(key, arg);
            }
        }
    }

    private void checkLengthArrayArgs(String[] args) {
        if (args.length < LENGTH_ARGS) {
            throw new IllegalArgumentException("Указаны не все аргументы командной строки");
        }
    }

    public String directory() {
        return mapArgs.get("-d");
    }

    public String exclude() {
        return mapArgs.get("-e");
    }

    public String output() {
        return mapArgs.get("-o");
    }
}