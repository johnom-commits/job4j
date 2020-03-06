package io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

class Shell {
    private Stack<String> stack = new Stack<>();
    private final Map<String, BiConsumer<Stack<String>, String>> map = new HashMap<>();

    public Shell(String dir) {
        stack.push(dir);
    }

    private BiConsumer<Stack<String>, String> act2() {
        return (st, path) -> {
            st.pop();
            if (st.size() > 1) {
                st.pop();
            }
        };
    }

    private BiConsumer<Stack<String>, String> act3() {
        return (st, path) -> {
            st.clear();
            st.push(path);
        };
    }

    private BiConsumer<Stack<String>, String> act4() {
        return (st, path) -> {
            if (st.size() > 2) {
                st.pop();
                st.pop();
            } else {
                st.clear();
                st.push("/");
            }
        };
    }

    private BiConsumer<Stack<String>, String> act5() {
        return (st, path) -> {
            if (path.endsWith("///")) {
                st.clear();
                st.push("/");
                st.push(path.substring(2, 5));
            } else {
                st.clear();
                st.push("/");
            }
        };
    }

    private BiConsumer<Stack<String>, String> act6() {
        return (st, path) -> {
            if (!st.peek().equals("/")) {
                st.push("/");
            }
            st.push(path);
        };
    }

    private void init() {
        map.put("..", act2());
        map.put("/", act3());
        map.put("end/..", act4());
        map.put("start//", act5());
        map.put("zzz", act6());
    }

    public Shell cd(final String path) throws IOException {
        if (path.isEmpty()) {
            throw new IOException("Должен быть указан путь к каталогу или ..");
        }

        init();
        String key = path;
        if (path.endsWith("/..")) {
            key = "end/..";
        } else if (path.startsWith("//")) {
            key = "start//";
        } else if ((!path.contains("/")) && (!path.contains(".")) && (!path.contains(".."))) {
            key = "zzz";
        }
        BiConsumer<Stack<String>, String> consumer = map.get(key);
        if (consumer != null) {
            consumer.accept(stack, path);
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
