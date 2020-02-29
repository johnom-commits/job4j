package io;

import java.io.IOException;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

class Shell {
    private Stack<String> stack = new Stack<>();

    public Shell(String dir) {
        stack.push(dir);
    }

    public Shell cd(final String path) throws IOException {
        if (path.isEmpty()) {
            throw new IOException("Должен быть указан путь к каталогу или ..");
        }

        if ("..".equals(path)) {
            stack.pop();
            if (stack.size() > 1) {
                stack.pop();
            }
        } else if ("/".equals(path)) {
            stack.clear();
            stack.push(path);
        } else if (path.endsWith("/..")) {
            if (stack.size() > 2) {
                stack.pop();
                stack.pop();
            } else {
                stack.clear();
                stack.push("/");
            }
        } else if (path.startsWith("//")) {
            if (path.endsWith("///")) {
                stack.clear();
                stack.push("/");
                stack.push(path.substring(2, 5));
            } else {
                stack.clear();
                stack.push("/");
            }
        } else if ((!path.contains("/")) && (!path.contains(".")) && (!path.contains(".."))) {
            if (!stack.peek().equals("/")) {
                stack.push("/");
            }
            stack.push(path);
        }
        return this;
    }

    public String path() {
        AtomicReference<String> dir = new AtomicReference<>("");
        stack.stream().forEach(e -> dir.set(dir + e));
        return dir.get();
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
