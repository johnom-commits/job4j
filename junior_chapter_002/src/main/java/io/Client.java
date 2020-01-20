package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void run() throws IOException {
        var out = new PrintWriter(socket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var console = new Scanner(System.in);
        String str = "";
        String text = "";
        do {
            if (console.hasNext()) {
                text = console.nextLine();
                out.println(text);
            }
            str = in.readLine();
            while (!text.equals("exit") && !str.isEmpty()) {
                System.out.println(str);
            }
        } while (!text.equals("exit"));
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            new Client(socket).run();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
