package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void man() {
        double in = 180;
        double expected = 92;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void woman() {
        double in = 160;
        double expected = 69;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}



