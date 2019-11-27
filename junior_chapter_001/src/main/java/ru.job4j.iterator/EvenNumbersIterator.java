package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] values;
    private int index = 0;
    private int indexEven = 0;
    private long lengthEven = 0;

    public EvenNumbersIterator(final int[] aValues) {
        values = aValues;
        lengthEven = Arrays.stream(values).filter(n -> (n % 2) == 0).count();
    }

    @Override
    public boolean hasNext() {
        return indexEven < lengthEven;
    }

    @Override
    public Object next() throws NoSuchElementException {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        for (int i = index; i < values.length; i++) {
            index++;
            if (values[i] % 2 == 0) {
                indexEven++;
                return values[i];
            }
        }
        return null;
    }
}
