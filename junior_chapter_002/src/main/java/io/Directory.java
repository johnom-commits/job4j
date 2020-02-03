package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Shell {
    private String currentDir;
    private String separator = File.separator;

    public Shell(String currentDir) {
        this.currentDir = currentDir;
    }

    Shell cd(final String path) throws IOException {
        if (path.isEmpty()) {
            throw new IOException("Должен быть указан путь к каталогу или ..");
        }

        String newDir = "";
        if ("..".equals(path)) {
            int index = currentDir.lastIndexOf(separator);
            newDir = currentDir.substring(0, index);
        } else {
            String slash = "";
            if (!currentDir.endsWith(separator)) {
                slash = separator;
            }
            newDir = String.join(slash, currentDir, path);
            if (!Files.exists(Paths.get(newDir))) {
                throw new IOException("Данный каталог не существует");
            }
        }
        currentDir = newDir;
        return this;
    }

    public String path() {
        return currentDir;
    }
}

public class Directory {

//    public static void main(String[] args) {
//        final Shell shell = new Shell();
//        assert shell.path().equals("/");
//        shell.cd("/");
//        assert shell.path().equals("/");
//        shell.cd("usr/..");
//        assert shell.path().equals("/");
//        shell.cd("usr").cd("local");
//        shell.cd("../local").cd("./");
//        assert shell.path().equals("/usr/local");
//        shell.cd("..");
//        assert shell.path().equals("/usr");
//        shell.cd("//lib///");
//        assert shell.path().equals("/lib");
//    }
}
