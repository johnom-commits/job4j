package ru.job4j.map;

import java.util.*;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class MyHashMap<K, V> implements Iterable<V> {
    private DataItem<K, V>[] table;
    private int size = 0;
    private int modCount = 0;

    public MyHashMap(int sizeArray) {
        table = (DataItem<K, V>[]) new DataItem[sizeArray];
    }

    private int getBucket(K key, int length) {
        int hash = Math.abs(key.hashCode());
        return hash % length;
    }

    public boolean insert(K key, V value) {
        if (size == table.length) {
            resize();
        }
        int bucket = getBucket(key, table.length);
        if (table[bucket] != null) {
            return false;
        }
        DataItem<K, V> item = new DataItem<>(key, value);
        table[bucket] = item;
        size++;
        modCount++;
        return true;
    }

    private void resize() {
        DataItem<K, V>[] newTable = (DataItem<K, V>[]) new DataItem[table.length * 2];
        for (var e : table) {
            K key = e.getKey();
            V value = e.getData();
            int bucket = getBucket(key, newTable.length);
            DataItem<K, V> item = new DataItem<>(key, value);
            newTable[bucket] = item;
        }
        table = newTable;
    }

    public V get(K key) {
        int bucket = getBucket(key, table.length);
        return table[bucket].getData();
    }

    public boolean delete(K key) {
        int bucket = getBucket(key, table.length);
        table[bucket].setData(null);
        return true;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<V> {
        int index = -1;
        int expectedModCount = modCount;
        List<DataItem<K, V>> list = stream(table).filter(x -> x != null).collect(toList());

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return index < list.size();
        }

        @Override
        public V next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(++index).getData();
        }
    }
}
