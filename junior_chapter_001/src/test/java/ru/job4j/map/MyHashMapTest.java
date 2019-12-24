package ru.job4j.map;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void whenAddNewItemAndGetItem() {
        MyHashMap<String, String> map = new MyHashMap<>(8);
        map.insert("Name", "Ivan");
        map.insert("Surname", "Ivanov");
        String result = map.get("Name");

        assertEquals(result, "Ivan");
    }

    @Test
    public void whenAddNewItemAndDeleteItem() {
        MyHashMap<String, String> map = new MyHashMap<>(8);
        map.insert("Name", "Ivan");
        map.insert("Surname", "Ivanov");
        map.delete("Surname");
        String result = map.get("Surname");

        assertNull(result);
    }

    @Test
    public void whenAddTheSameTwoTimes() {
        MyHashMap<String, String> map = new MyHashMap<>(8);
        map.insert("Name", "Ivan");
        Boolean result = map.insert("Name", "Ivan");

        assertFalse(result);
    }

    @Test
    public void whenResizeTable() {
        MyHashMap<Integer, String> map = new MyHashMap<>(3);
        map.insert(1, "One");
        map.insert(2, "Two");
        map.insert(3, "Three");
        boolean result = map.insert(4, "Four");     // здесь проверяем увеличение таблицы

        assertTrue(result);
    }

    @Test
    public void whenUseIterator() {
        MyHashMap<Integer, String> map = new MyHashMap<>(3);
        map.insert(1, "One");
        map.insert(2, "Two");
        map.insert(3, "Three");

        Iterator it = map.iterator();
        it.hasNext();
        it.next();
        it.next();

        assertTrue(it.hasNext());
    }

    @Test
    public void whenIteratorReturnValue() {
        MyHashMap<Integer, String> map = new MyHashMap<>(3);
        map.insert(1, "One");

        Iterator it = map.iterator();
        it.hasNext();

        assertEquals("One", it.next());
    }

    @Test
    public void whenUseIteratorForEmptyMap() {
        MyHashMap<Integer, String> map = new MyHashMap<>(3);
        Iterator it = map.iterator();

        assertFalse(it.hasNext());
    }

    @Test
    public void whenUseIteratorAndDeleteItem() {
        MyHashMap<Integer, String> map = new MyHashMap<>(3);
        map.insert(1, "One");
        map.delete(1);
        Iterator it = map.iterator();

        assertFalse(it.hasNext());
    }
}