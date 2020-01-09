package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Chat {
    private static final int MAX_LINE = 4000;
    private static final String WAY_PHRASE = "C:/projects/phrases.txt";
    private static final String WAY_LOG = "C:/projects/log.txt";

    public static void main(String[] args) throws IOException {
        try (var out = new PrintWriter(new FileOutputStream(WAY_LOG))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите сообщение:");
            Boolean stop = false;

            String str = br.readLine();
            logging(out, str, " User: ");
            do {
                if (!stop) {
                    Files.lines(Paths.get(WAY_PHRASE)).skip(rnd()).limit(1).peek(s -> logging(out, s, " Bot:  ")).forEach(System.out::println);
                }
                str = br.readLine();
                if (str.equals("Стоп")) {
                    stop = true;
                }
                if (str.equals("Продолжить")) {
                    stop = false;
                }
                logging(out, str, " User: ");
            } while (!str.equals("Закончить"));
        }
    }

    private static int rnd() {
        return (int) (Math.random() * MAX_LINE);
    }

    private static void logging(PrintWriter out, String str, String source) {
        out.println(new StringBuilder(new Date().toString())
                .append(source)
                .append(str));
    }
}
