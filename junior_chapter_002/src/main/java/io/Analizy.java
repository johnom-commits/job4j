package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();

        try (var read = new BufferedReader(new FileReader(source))) {
            list = read.lines().collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (var out = new PrintWriter(new FileOutputStream(target))) {
            String startServer = "";
            for (var entry : list) {
                String[] a = entry.split(" ");

                if ((a[0].equals("500") || a[0].equals("400")) && startServer.isEmpty()) {
                    startServer = a[1];
                }
                if ((a[0].equals("200") || a[0].equals("300")) && !startServer.isEmpty()) {
                    var lineLog = new StringBuilder(startServer)
                        .append(";")
                        .append(a[1]);
                    out.println(lineLog);
                    startServer = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
