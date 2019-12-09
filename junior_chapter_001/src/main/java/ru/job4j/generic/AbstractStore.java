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
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        simpleArray.set(index, (T) model);
        return true;
    }

    @Override
    public T findById(String id) {
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            T item = it.next();
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    private int findIndex(String id) {
        int index = -1;
        int k = 0;
        for (T item : simpleArray) {
            if (item.getId().equals(id)) {
                index = k;
                break;
            }
            k++;
        }
        return index;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndex(id);
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
