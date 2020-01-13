package io;

import java.util.HashMap;
import java.util.Map;

public class Args {
    Map<String, String> mapArgs = new HashMap<>();

    public Args(String[] args) {
        parsingArgs(args);
    }

    private void parsingArgs(String[] args) {
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "-e":
                    mapArgs.put("exclude", args[++i]);
                    i++;
                    break;
                case "-d":
                    mapArgs.put("directory", args[++i]);
                    i++;
                    break;
                case "-o":
                    mapArgs.put("output", args[++i]);
                    i++;
                    break;
            }
        }
    }

    public String directory() {
        return mapArgs.get("directory");
    }

    public String exclude() {
        return mapArgs.get("exclude");
    }

    public String output() {
        return mapArgs.get("output");
    }
}