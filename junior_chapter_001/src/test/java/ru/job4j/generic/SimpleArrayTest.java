package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddAndGetItem() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        assertThat(array.get(3), is(4));
    }

    @Test
    public void whenSetItem() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.set(2, 10);

        assertThat(array.get(2), is(10));
    }

    @Test
    public void whenRemoveItem() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("Test");
        array.add("Name");
        array.add("John");
        array.add("Bill");
        array.add("Tom");
        array.remove(1);

        assertThat(array.get(1), is("John"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddItem() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        assertThat(array.get(3), is(4));
    }

    @Test
    public void whenHaveIterator() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> iterator = array.iteratorA();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenHaveIteratorNoItems() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        Iterator<Integer> iterator = array.iteratorA();

        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenHaveIteratorItemsLessLenght() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        Iterator<Integer> iterator = array.iteratorA();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }
}