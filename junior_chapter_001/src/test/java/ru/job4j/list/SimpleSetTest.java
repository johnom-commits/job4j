package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest<E> {

    SimpleSet<String> set = new SimpleSet<>(10);

    @Before
    public void init() {
        set.add("Трусова");
        set.add("Щербакова");
        set.add("Щербакова");
        set.add("Косторная");
    }

    @Test
    public void whenAddandIsPresentTest() {
        assertThat(set.isPresent("Косторная"), is(true));
    }

    @Test
    public void whenHasIterator() {
        Iterator<String> it = set.eIterator();
        it.next();
        it.next();
        it.next();
        // Проверяем, что в сете 3 элемента, а не 4.
        assertThat(it.hasNext(), is(false));
    }
}