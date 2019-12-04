package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ContainerLinkedListTest {

    private ContainerLinkedList<String> list;

    @Before
    public void beforeTest() {
        list = new ContainerLinkedList<>();
        list.add("Lada Niva");
        list.add("Lada Kalina");
        list.add("Lada Priora");
        list.add("Lada Vesta");
        list.add("Lada Granta");
        list.add("Lada Oka");
    }

    @Test
    public void whenAddGetItemsMoreThanDefaultSize() {
        assertThat(list.get(0), is("Lada Oka"));
    }

    @Test
    public void whenUseIterator() {
        var it = list.iterator();
        it.hasNext();
        it.next();
        it.next();
        var expected = it.next();

        assertThat(expected, is("Lada Vesta"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListModified() {
        var it = list.iterator();
        it.hasNext();
        it.next();
        list.add("Lada Samara");
        it.next();
    }
}