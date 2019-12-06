package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void whenPushAndPullQueue() {
        var queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        queue.poll();
        queue.poll();
        queue.push(4);
        queue.push(5);
        assertThat(queue.poll(), is(3));
    }
}