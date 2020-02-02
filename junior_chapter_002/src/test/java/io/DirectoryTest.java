package io;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class DirectoryTest {
    String directory = System.getProperty("java.io.tmpdir");

    @Before
    public void init() {
        File file = new File(directory + "\\dir1\\dir2\\dir3");
        file.mkdirs();
    }

    @Test
    public void whenMoveDownToPath() throws IOException {
        Shell shell = new Shell(directory);
        shell.cd("dir1");
        shell.cd("dir2");
        shell.cd("dir3");

        assertEquals(directory + "dir1\\dir2\\dir3", shell.path());
    }

    @Test
    public void whenMoveUpToPath() throws IOException {
        Shell shell = new Shell(directory+ "dir1\\dir2\\dir3");
        shell.cd("..");

        assertEquals(directory + "dir1\\dir2", shell.path());
    }
}