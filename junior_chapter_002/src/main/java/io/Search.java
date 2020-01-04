package io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        List<File> listFiles = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File root = new File(parent);

        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isFile() && checkExt(file.getName(), exts)) {
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

    private Boolean checkExt(String name, List<String> exts) {
        String[] partsName = name.split("\\.");
        if (partsName.length == 1) {
            return false;
        }
        int indexExt = partsName.length - 1;
        return exts.contains(partsName[indexExt]);
    }
}
