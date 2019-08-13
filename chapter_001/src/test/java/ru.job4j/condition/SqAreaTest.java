package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public  void square1() {
        int p = 4;
        int k = 1;
        int expected = 1;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }

    @Test
    public  void square2() {
        int p = 6;
        int k = 2;
        int expected = 2;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }
}
