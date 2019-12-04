package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private SimpleArrayList<E> list;
    private int modCount = 0;

    public ContainerLinkedList() {
        list = new SimpleArrayList<E>();
    }

    public void add(E value) {
        list.add(value);
        size++;
        modCount++;
    }

    public E get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        int index = -1;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return index < size;
        }

        @Override
        public E next() throws ConcurrentModificationException, NoSuchElementException {
            if (index == size) {
                throw new NoSuchElementException("Достигнут конец массива");
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            index++;
            return get(index);
        }
    }
}
