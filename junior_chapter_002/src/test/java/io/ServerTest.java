package io;

import com.google.common.base.Joiner;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenSendExitThenNothing() throws IOException {
        String input = "exit";
        String output = "";
        testServer(input, output);
    }

    @Test
    public void whenSendHelloThenAsk() throws IOException {
        String input = Joiner
                .on(LN)
                .join("Hello", "exit");
        String output = Joiner
                .on(LN)
                .join("Hello, dear friend, I'm a oracle.", "", "");
        testServer(input, output);
    }

    @Test
    public void whenSendUnsupportedCommandThenGood() throws IOException {
        String input = Joiner.on(LN).join("How are you", "exit");
        String output = Joiner.on(LN).join("Good", "", "");
        testServer(input, output);
    }

    private void testServer(String input, String output) throws IOException {
        Socket socket = mock(Socket.class);
        var out = new ByteArrayOutputStream();
        var in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        Server server = new Server(socket);
        server.run();

        assertEquals(output, out.toString());
    }
}