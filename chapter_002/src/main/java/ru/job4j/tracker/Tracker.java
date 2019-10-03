package ru.job4j.tracker;

import java.util.Random;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /** Массив для хранение заявок. */
    private final Item[] items = new Item[100];
    /**Указатель ячейки для новой заявки. */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
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
        Item previous = this.findById(id);
        if (previous != null) {
            String tmpName = previous.getName();
            String tmpId = previous.getId();
            previous.setName(item.getName());
            previous.setId(item.getId());
            item.setName(tmpName);
            item.setId(tmpId);
            return tmpName.equals(item.getName());
        } else return false;
    }

    public boolean delete(String id) {
        int index = 0;
        boolean find = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                index = i;
                find = true;
                break;
            }
        }
        if (find) {
            position--;
            Item[] array = new Item[100];
            if (index == 0) {
                System.arraycopy(items, 1, array, 0, position);
            } else {
                System.arraycopy(items, 0, array, 0, index - 1);
                System.arraycopy(items, index + 1, array, index - 1, position - index);
            }
            System.arraycopy(array, 0, items, 0, 100);
            return true;
        } else return false;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
