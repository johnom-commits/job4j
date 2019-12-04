package ru.job4j.list;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleDinamicListTest {

    @Test
    public void whenAddGetItemsMoreThanDefaultSize() {
        var list = new SimpleDinamicList<String>();
        list.add("Lada Niva");
        list.add("Lada Kalina");
        list.add("Lada Priora");
        list.add("Lada Vesta");
        list.add("Lada Granta");
        list.add("Lada Oka");

        assertThat(list.get(5), is("Lada Oka"));
    }

    @Test
    public void whenUseIterator() {
        var list = new SimpleDinamicList<String>();
        list.add("Lada Niva");
        list.add("Lada Kalina");
        list.add("Lada Priora");
        list.add("Lada Vesta");
        list.add("Lada Granta");
        list.add("Lada Oka");
        var it = list.iterator();
        it.hasNext();
        it.next();
        it.next();
        var expected = it.next();

        assertThat(expected, is("Lada Priora"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListModified() {
        var list = new SimpleDinamicList<String>();
        list.add("Lada Niva");
        list.add("Lada Kalina");
        list.add("Lada Priora");
        list.add("Lada Vesta");
        list.add("Lada Granta");
        list.add("Lada Oka");
        var it = list.iterator();
        it.hasNext();
        it.next();
        list.add("Lada Samara");
        it.next();
    }
}