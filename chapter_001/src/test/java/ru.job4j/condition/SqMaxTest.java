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

    @Test
    public void sq2() {
        int first = 10;
        int second = 5;
        int third = 5;
        int forth = 9;
        int expected = 10;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void sq3() {
        int first = 11;
        int second = 2;
        int third = 4;
        int forth = 3;
        int expected = 11;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void sq4() {
        int first = 2;
        int second = 8;
        int third = 15;
        int forth = 9;
        int expected = 15;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void sq5() {
        int first = 2;
        int second = 14;
        int third = 10;
        int forth = 1;
        int expected = 14;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void sq6() {
        int first = 2;
        int second = 4;
        int third = 6;
        int forth = 8;
        int expected = 8;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void sq7() {
        int first = 4;
        int second = 3;
        int third = 2;
        int forth = 1;
        int expected = 4;
        int out = SqMax.max(first, second, third, forth);
        Assert.assertEquals(expected, out);
    }
}
