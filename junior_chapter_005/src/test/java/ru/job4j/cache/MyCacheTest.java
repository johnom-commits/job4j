package ru.job4j.cache;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.StringJoiner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyCacheTest {
    String dir;
    Path path;

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void createFileForRead() throws IOException {
        var lines = Arrays.asList("Галкин", "Малкин", "Палкин", "Чалкин", "Залкинд");
        dir = folder.newFolder().toString();
        path = Path.of(dir, "Names.txt");
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    @Test
    public void whenReadFromFileAndThenReadFromCache() throws IOException {
        var cache = new MyCache(dir);
        var textFromFile = cache.get("Names.txt");
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Галкин")
                .add("Малкин")
                .add("Палкин")
                .add("Чалкин")
                .add("Залкинд")
                .toString();
        assertThat(textFromFile, is(expect));

        Files.delete(path);
        var textFromCache = cache.get("Names.txt");
        assertThat(textFromCache, is(expect));
   }
}