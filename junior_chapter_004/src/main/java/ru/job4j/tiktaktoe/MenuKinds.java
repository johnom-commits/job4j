package ru.job4j.tiktaktoe;

import java.util.ArrayList;
import java.util.List;

public class MenuKinds {
    List<ItemKind> list = new ArrayList<>();

    public void add(ItemKind item) {
        list.add(item);
    }

    public void show() {
        for (ItemKind item : list) {
            System.out.println(item.getIndex() + ". " + item.getHeader());
        }
    }

    public ItemKind findItem(int index) {
        ItemKind result = null;
        for (ItemKind item : list) {
            if (index == item.getIndex()) {
                result = item;
                break;
            }
        }
        return result;
    }
}

