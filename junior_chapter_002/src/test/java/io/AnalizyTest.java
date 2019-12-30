package io;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenAnalizLog() {
        String target = "log.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable("source.txt", target);

        String result = "";
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            result = read.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(result, "10:57:01;10:59:01");
    }

}