package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) throws NoSuchElementException {

        return new Iterator<Integer>() {

            private Iterator<Integer> itNested = it.next();

            @Override
            public boolean hasNext() {
                if (!itNested.hasNext() && it.hasNext()) {
                    itNested = it.next();
                }
                return itNested.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!it.hasNext() && !itNested.hasNext()) {
                    throw new NoSuchElementException("Извиняйте, бананьев нема");
                }
                if (!itNested.hasNext() && it.hasNext()) {
                    itNested = it.next();
                }
                return itNested.next();
            }
        };
    }
}
