package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void whenScanFileSystemTemp() throws IOException {
        String directory = System.getProperty("java.io.tmpdir");
        File file1 = new File(directory, "test.txt");
        file1.createNewFile();
        File file2 = new File(directory, "test2.xml");
        file2.createNewFile();
        File file3 = new File(directory, "test3.txt");
        file3.createNewFile();
        Search search = new Search();
        List<File> result = search.files(directory, FilesPredicate.textFiles);

        List<File> expected = new  ArrayList<>();
        expected.add(file1);
        expected.add(file3);
        assertThat(expected, is(result));
    }
}