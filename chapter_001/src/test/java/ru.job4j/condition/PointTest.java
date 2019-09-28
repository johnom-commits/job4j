package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2() {
        Point a = new Point(2, 1);
        Point b = new Point(4, 3);
        double expected = 2.82;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3() {
        Point a = new Point(1, 2);
        Point b = new Point(9, 11);
        double expected = 12.04;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
