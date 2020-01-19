package io;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilesPredicate {
    public static Predicate<String> textFiles = new Predicate<>() {
        @Override
        public boolean test(String name) {
            List<String> listExts = Arrays.asList("txt");

            String[] partsName = name.split("\\.");
            if (partsName.length == 1) {
                return false;
            }
            int indexExt = partsName.length - 1;
            return listExts.contains(partsName[indexExt]);
        }
    };
}
