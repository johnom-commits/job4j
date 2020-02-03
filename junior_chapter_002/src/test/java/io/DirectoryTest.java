package io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class DirectoryTest {
    private String directory = System.getProperty("java.io.tmpdir");
    private char sep = File.separatorChar;
    private String path = String.format("%sdir1%sdir2%sdir3", directory, sep, sep);

    @Before
    public void init() {
        File file = new File(path);
        file.mkdirs();
    }

    @After
    public void delete() {
        String p = directory + "dir1";
        File file = new File(p);
        delete(file);
    }

    private Boolean delete(final File file) {
        Boolean result = false;
        if (file.isDirectory()) {
            String[] files = file.list();
            if ((null == files) || (files.length == 0)) {
                result = file.delete();
            } else {
                for (final String filename: files) {
                    delete(new File(file.getAbsolutePath() + sep + filename));
                }
                result = file.delete();
            }
        } else {
            result = file.delete();
        }
        return result;
    }

    @Test
    public void whenMoveDownToPath() throws IOException {
        Shell shell = new Shell(directory);
        shell.cd("dir1");
        shell.cd("dir2");
        shell.cd("dir3");

        assertEquals(path, shell.path());
    }

    @Test
    public void whenMoveUpToPath() throws IOException {
        Shell shell = new Shell(path);
        shell.cd("..");

        String expected = String.format("%sdir1%sdir2", directory, sep);
        assertEquals(expected, shell.path());
    }
}