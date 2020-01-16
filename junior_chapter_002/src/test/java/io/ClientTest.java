package io;

import org.junit.Test;
import java.io.*;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenSendExit() throws IOException {
        Socket socket = mock(Socket.class);
        var out = new ByteArrayOutputStream();
        var in = new ByteArrayInputStream("".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        OutputStream answerServer = new ByteArrayOutputStream();
        InputStream inputConsole = new ByteArrayInputStream("exit".getBytes());
        System.setIn(inputConsole);
        System.setOut(new PrintStream(answerServer));

        Client client = new Client(socket);
        client.run();

        assertEquals("", answerServer.toString());
    }
}