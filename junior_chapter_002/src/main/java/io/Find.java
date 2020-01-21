package io;

import org.apache.commons.cli.ParseException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class Find {
    public static void main(String[] args) throws ParseException {
        Parsing arg = new Parsing(args);
        List<String> list = files(arg.directory(), PredicateFiles.getFiels(arg.name(), arg.typeName()));
        writeLog(arg.output(), list);
    }

    private static void writeLog(String path, List<String> listLog) {
        Charset utf8 = StandardCharsets.UTF_8;
        try {
            Files.write(Paths.get(path), listLog, utf8);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static List<String> files(String parent, Predicate<String> stringPredicate) {
        List<String> listFiles = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File root = new File(parent);

        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isFile() && stringPredicate.test(file.getName())) {
                listFiles.add(file.getName());
            }
            File[] leafs = file.listFiles();
            if (leafs != null) {
                for (var f : leafs) {
                    queue.offer(f);
                }
            }
        }
        return listFiles;
    }
}
