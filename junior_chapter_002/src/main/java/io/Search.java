package io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class Search {

    public List<File> files(String parent, Predicate<String> stringPredicate) {
        List<File> listFiles = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File root = new File(parent);

        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isFile() && stringPredicate.test(file.getName())) {
                listFiles.add(file);
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
