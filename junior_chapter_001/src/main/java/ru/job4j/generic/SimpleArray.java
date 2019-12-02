package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> {

    private T[] array;
    private int index = 0;
    private int size;

    public SimpleArray(int size) {
        array = (T[]) new Object[size];
        this.size = size;
    }

    public void add(T value) throws ArrayIndexOutOfBoundsException {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        array[index] = value;
        index++;
    }

    public T get(int i) {
        Objects.checkIndex(i, size);
        return array[i];
    }

    public void set(int i, T value) {
        Objects.checkIndex(i, size);
        array[i] = value;
    }

    public void remove(int i) {
        Objects.checkIndex(i, size);
        System.arraycopy(array, i, array, i - 1, array.length - 1);
        index--;
    }

    public Iterator<T> iteratorA() {

        return new Iterator<T>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < index;
            }

            @Override
            public T next() {
               T result = array[count];
               count++;
               return result;
            }
        };
    }
}
