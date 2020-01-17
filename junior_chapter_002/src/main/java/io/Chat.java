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

public class Chat {
    private static final int MAX_LINE = 4000;
    private List<String> phases = new ArrayList<>(MAX_LINE);
    private List<String> listLog = new ArrayList<>();
    private static final String WAY_PHRASE = "./../phrases.txt";
    private static final String WAY_LOG = "./../log.txt";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";
    private static final String FINISH = "Закончить";

    public static void main(String[] args) throws IOException {
        Chat main = new Chat();
        main.readPhrases();
        main.readConsoleAndPrintPhrase();
    }

    private void readConsoleAndPrintPhrase() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите сообщение:");
        Boolean stop = false;
        String str = "";
        do {
            str = br.readLine();
            if (STOP.equals(str)) {
                stop = true;
            }
            if (CONTINUE.equals(str)) {
                stop = false;
            }
            logging(str, " User: ");
            if (!stop && !FINISH.equals(str)) {
                printPhrase();
            }
        } while (!FINISH.equals(str));
        writeLog();
    }

    private void readPhrases() {
        try {
            phases = Files.readAllLines(Paths.get(WAY_PHRASE));
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
