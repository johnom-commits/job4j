package io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void pack(List<File> source, File target) {
        try (var zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (var out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> seekBy(String parent, String exts) {
        List<File> list = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File root = new File(parent);
        List<String> listExts = parsingExt(exts);

        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();

            if (checkExt(file.getName(), listExts)) {
                list.add(file);
            }
            File[] leafs = file.listFiles();
            if (leafs != null) {
                for (var f : leafs) {
                    queue.offer(f);
                }
            }
        }
        return list;
    }

    private List<String> parsingExt(String exts) {
        // парсим строку вида: *.java *.xml *.iml
        List<String> listExt = new ArrayList<>();
        var pattern = Pattern.compile("[a-z]+");
        var matcher = pattern.matcher(exts);
        while (matcher.find()) {
            listExt.add(matcher.group());
        }
        return listExt;
    }

    private Boolean checkExt(String name, List<String> exts) {
        String[] partsName = name.split("\\.");
        if (partsName.length == 1) {
            return false;
        }
        int indexExt = partsName.length - 1;
        return !exts.contains(partsName[indexExt]);
    }

    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip();
        var list = zip.seekBy(args1.directory(), args1.exclude());
        zip.pack(list, new File(args1.output()));
    }
}
