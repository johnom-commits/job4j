package ru.job4j.generic;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> simpleArray;
    int index = 0;

    AbstractStore() {
        simpleArray = new SimpleArray<>(10);
    }

    @Override
    public void add(Base model) {
        simpleArray.add((T) model);
        index++;
    }

    @Override
    public boolean replace(String id, Base model) {
        T item = findById(id);
        int index = simpleArray.indexOf(item);
        if (index == -1) {
            return false;
        }
        simpleArray.set(index, (T) model);
        return true;
    }

    @Override
    public T findById(String id) {
        Iterator<T> it = simpleArray.iteratorA();
        while (it.hasNext()) {
            T item = it.next();
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        T item = findById(id);
        int index = simpleArray.indexOf(item);
        if (index == -1) {
            return false;
        }
        simpleArray.remove(index);
        this.index--;
        return true;
    }

    public int size() {
        return index;
    }
}
