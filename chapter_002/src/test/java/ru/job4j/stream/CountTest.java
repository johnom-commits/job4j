package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountTest {

    @Test
    public void count() {
        var list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(Count.count(list), is(56));
    }
}