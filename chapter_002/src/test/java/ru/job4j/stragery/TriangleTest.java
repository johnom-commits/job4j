package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Shape triangle = new Triangle();
        String result = triangle.draw();
        String expected = new StringBuilder()
                .append("   +  ")
                .append(System.lineSeparator())
                .append("  +  +")
                .append(System.lineSeparator())
                .append(" +    +")
                .append(System.lineSeparator())
                .append("++++++++")
                .toString();
        assertThat(result, is(expected));
    }
}
