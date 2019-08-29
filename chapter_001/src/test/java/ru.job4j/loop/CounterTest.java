package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        int start = 1;
        int finish = 10;
        int expected = 30;
        Counter counter = new Counter();
        int out = counter.add(start, finish);
        Assert.assertEquals(expected, out);
    }
}