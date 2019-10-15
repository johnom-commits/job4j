package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import java.util.Random;

public enum  TrackerSingle {
    INSTANCE;

    private final Item[] items = new Item[100];

    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public Item findById(String id) {
        Item tmp = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                tmp = items[i];
                break;
            }
        }
        return tmp;
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[position];
        int index = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                array[index] = items[i];
                index++;
            }
        }
        Item[] copy = new Item[index];
        System.arraycopy(array, 0, copy, 0, index);
        return copy;
    }

    public Item[] findAll() {
        Item[] copy = new Item[position];
        System.arraycopy(items, 0, copy, 0, position);
        return copy;
    }

    public boolean replace(String id, Item item) {
        Boolean flag = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                flag = true;
                items[i] = item;
                break;
            }
        }
        return flag;
    }

    public boolean delete(String id) {
        int index = 0;
        boolean find = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                find = true;
                break;
            }
        }
        return find;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
