package ru.job4j.list;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    SimpleArray<E> set;
    int size = 0;

    public SimpleSet(int size) {
        set = new SimpleArray<>(size);
    }

    public void add(E e) {
        if (!isPresent(e)) {
            set.add(e);
            size++;
        }
    }

    public boolean isPresent(E e) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            E item = set.get(i);
            if (e == null) {
                return  (item == null) ? true : false;
            }
            if (e.equals(item)) {
                result = true;
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        return set.iterator();
    }
}
