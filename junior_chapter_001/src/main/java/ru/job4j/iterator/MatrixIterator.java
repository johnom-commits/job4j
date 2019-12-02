package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int index = 0;
    private int length = 0;
    private int row = 0;
    private int colomn = -1;

    public MatrixIterator(final int[][] aValues) {
        values = aValues;
        for (var row : values) {
            for (var col : row) {
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
        if (!hasNext()) {
            throw new NoSuchElementException("Выход за пределы массива");
        }

        if (colomn == values[row].length - 1) {
            colomn = 0;
            row++;
        } else {
            colomn++;
        }
        index++;
        return values[row][colomn];
    }
}
