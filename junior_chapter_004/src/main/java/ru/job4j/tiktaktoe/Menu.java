package ru.job4j.tiktaktoe;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<ItemSize> list = new ArrayList<>();

    public void add(ItemSize item) {
        list.add(item);
    }

    public void show() {
        for (ItemSize item : list) {
            System.out.println(item.getIndex() + ". " + item.getHeader());
        }
    }

    public ItemSize findItem(int index) {
        ItemSize result = null;
        for (ItemSize item : list) {
            if (index == item.getIndex()) {
                result = item;
                break;
            }
        }
        return result;
    }
}

