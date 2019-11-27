package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int index = 0;
    private int length = 0;

    public MatrixIterator(final int[][] aValues) {
        values = aValues;
        for (var row : values) {
            for (var colomn : row) {
                length++;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public Object next() {
        index++;
        int count = 0;
        int i = 0;
        for (var row : values) {
            int j = 0;
            for (var colomn : row) {
                count++;
                if (index == count) {
                     return values[i][j];
                }
                j++;
            }
            i++;
        }
        return null;
    }
}
