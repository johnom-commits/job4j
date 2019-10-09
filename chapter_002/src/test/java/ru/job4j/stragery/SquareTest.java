package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String result = square.draw();
        String expected =   new StringBuilder()
                .append("+++++++")
                .append(System.lineSeparator())
                .append("+     +")
                .append(System.lineSeparator())
                .append("+     +")
                .append(System.lineSeparator())
                .append("+++++++")
                .toString();
        assertThat(result, is(expected));
    }
}
