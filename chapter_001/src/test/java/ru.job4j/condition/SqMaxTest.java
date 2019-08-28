package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqMaxTest {

    @Test
    public void sq1() {
        int first = 1;
        int second = 7;
        int third = 5;
        int forth = 9;
        int expected = 9;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }
}
