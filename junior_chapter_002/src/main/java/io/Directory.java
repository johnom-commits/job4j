package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Shell {
    private String currentDir;
    private String separator = "/";

    public Shell(String currentDir) {
        this.currentDir = currentDir;
    }

    public Shell cd(final String path) throws IOException {
        if (path.isEmpty()) {
            throw new IOException("Должен быть указан путь к каталогу или ..");
        }

        String newDir = "";
        String slash = "";
        if ("..".equals(path)) {
            int index = currentDir.lastIndexOf(separator); // заменить на функцию
            newDir = currentDir.substring(0, index);
        } else if ("./".equals(path)) {
            newDir = currentDir;
        } else if ("/".equals(path)) {
            newDir = "/";
        } else if (path.startsWith("../")) {
            int index = currentDir.lastIndexOf(separator);
            newDir = currentDir.substring(0, index);
            index = path.lastIndexOf(separator);
            newDir = newDir + path.substring(index);
        } else if (path.startsWith("//")) {
            if (path.endsWith("///")) {
                newDir = path.substring(1, path.length() - 3);
            } else {
                newDir = path.substring(1);
            }
        } else if (path.endsWith("/..")) {
            newDir = path.substring(0, path.length() - 3);
            if (newDir.contains(separator)) {
                int index = newDir.lastIndexOf(separator);
                newDir = newDir.substring(0, index);
            } else {
                newDir = separator;
            }
        } else {
            if (!currentDir.endsWith(separator)) {
                slash = separator;
            }
            newDir = String.join(slash, currentDir, path);
        }
        currentDir = newDir;
        return this;
    }

    public String path() {
        return currentDir;
    }
}

public class Directory {
    public static void main(String[] args) throws IOException {
        final Shell shell = new Shell("/");
        assert shell.path().equals("/");
        shell.cd("/");
        assert shell.path().equals("/");
        shell.cd("usr/..");
        assert shell.path().equals("/");
        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");
        shell.cd("..");
        assert shell.path().equals("/usr");
        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
}
