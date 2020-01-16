package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Socket socket;;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() throws IOException {
        var out = new PrintWriter(socket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask = "";
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!"exit".equals(ask)) {
                out.println("Good");
                out.println();
            }
        } while (!"exit".equals(ask));
    }

    public static void main(String[] args) {
        try (final Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).run();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
