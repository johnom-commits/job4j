package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Chat {
    private static final int MAX_LINE = 4000;
    private List<String> phases = new ArrayList<>(MAX_LINE);
    private List<String> listLog = new ArrayList<>();
    private static final String WAY_PHRASE = "C:/projects/phrases.txt";
    private static final String WAY_LOG = "C:/projects/log.txt";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";
    private static final String FINISH = "Закончить";

    public static void main(String[] args) throws IOException {
        Chat main = new Chat();
        main.readPhrases();

        var br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите сообщение:");
        Boolean stop = false;
        String str;
        do {
            str = br.readLine();
            if (str.equals(STOP)) {
                stop = true;
            }
            if (str.equals(CONTINUE)) {
                stop = false;
            }
            main.logging(str, " User: ");
            if (!stop && !str.equals(FINISH)) {
                main.printPhrase();
            }
        } while (!str.equals(FINISH));
        main.writeLog();
    }

    private void readPhrases() {
        try (var stream = Files.lines(Paths.get(WAY_PHRASE))) {
            phases = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printPhrase() {
        var phrase = phases.get(rnd());
        System.out.println(phrase);
        logging(phrase, " Bot:  ");
    }

    private static int rnd() {
        return (int) (Math.random() * MAX_LINE);
    }

    private void logging(String str, String source) {
        var textLog = new StringBuilder(new Date().toString())
                .append(source)
                .append(str);
        listLog.add(textLog.toString());
    }

    private void writeLog() {
        Charset utf8 = StandardCharsets.UTF_8;
        try {
            Files.write(Paths.get(WAY_LOG), listLog, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
