package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Ignore
    @Test
    public void whenMapHasRightNumberKeys() {
        Generator generator = new GeneratorString();
        Map<String, String> map = new HashMap<>();
        map.put("var1", "greetings");
        map.put("var2", "sun");
        String result = generator.produce("I came to you with ${var1}, to tell you that the ${var2} has risen", map);
        assertEquals("I came to you with greetings, to tell you that the sun has risen", result);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysLessInMap() {
        Generator generator = new GeneratorString();
        Map<String, String> map = new HashMap<>();
        map.put("var1", "Romeo");
        String result = generator.produce("There is no sadder story in the world than the story of ${var1} and ${var2}", map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysMoreInMap() {
        Generator generator = new GeneratorString();
        Map<String, String> map = new HashMap<>();
        map.put("var1", "help");
        map.put("var2", "do");
        String result = generator.produce("${var1} me if you can I feeling down", map);
    }
}