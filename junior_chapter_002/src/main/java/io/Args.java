package io;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Args {
    String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String directory() {
        return Arrays.stream(args).dropWhile(e -> !e.equals("-d")).skip(1).findFirst().get();
    }

    public String exclude() {
        return Arrays.stream(args).dropWhile(e -> !e.equals("-e")).skip(1).takeWhile(e -> !e.startsWith("-")).collect(Collectors.joining(" "));
    }

    public String output() {
        return Arrays.stream(args).dropWhile(e -> !e.equals("-o")).skip(1).findFirst().get();
    }
}
