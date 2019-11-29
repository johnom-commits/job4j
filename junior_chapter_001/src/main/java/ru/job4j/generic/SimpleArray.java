package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> {

    private T[] array;
    private int index = 0;

    public SimpleArray(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T value) throws ArrayIndexOutOfBoundsException {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        array[index] = value;
        index++;
    }

    public T get(int i) {
        return array[i];
    }

    public void set(int i, T value) {
        array[i] = value;
    }

    public void remove(int i) {
        System.arraycopy(array, i, array, i - 1, array.length - 1);
        index--;
    }

    public Iterator<T> iteratorA() {

        return new Iterator<T>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < array.length;
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
