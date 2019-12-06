package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListHasCircleTest {

    LinkedListHasCircle.Node first;
    LinkedListHasCircle.Node two;
    LinkedListHasCircle.Node third;
    LinkedListHasCircle.Node four;

    @Before
    public void init() {
        first = new LinkedListHasCircle.Node(1);
        two = new LinkedListHasCircle.Node(2);
        third = new LinkedListHasCircle.Node(3);
        four = new LinkedListHasCircle.Node(4);
    }

    @Test
    public void whenLinkedListCircle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        boolean result = LinkedListHasCircle.hasCycle(first);

        assertThat(result, is(true));
    }

    @Test
    public void whenLinkedListNoCircle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        boolean result = LinkedListHasCircle.hasCycle(first);

        assertThat(result, is(false));
    }

    @Test
    public void whenLinkedListCircleAnother() {
        first.next = two;
        two.next = third;
        third.next = first;
        four.next = null;
        boolean result = LinkedListHasCircle.hasCycle(first);

        assertThat(result, is(true));
    }
}