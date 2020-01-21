package io;

import java.util.function.Predicate;

public class PredicateFiles {
    public static Predicate<String> getFiels(String name, String typeName) {
        if (typeName.equals("-f")) {
            return i -> i.equals(name);
        }
        if (typeName.equals("-r")) {
            return i -> i.matches(name);
        }
        if (typeName.equals("-m")) {
            return i -> i.endsWith(name.replace("*", ""));
        }
        return null;
    }
}
