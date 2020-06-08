package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<InterItem> list = new ArrayList<>();

    public void add(InterItem item) {
        list.add(item);
    }

    public void show() {
        for (InterItem item : list) {
            System.out.println("- " + item.getHeader());
            showItems(item, 1);
        }
    }

    private void showItems(InterItem item, int level) {
        if (item.getItemIn() != null) {
            level++;
            for (InterItem item1 : item.getItemIn()) {
                System.out.println(beginStr(level) + " " + item1.getHeader());
                showItems(item1, level);
            }
        }
    }

    private String beginStr(int level) {
        String defis = "";
        for (int i = 1; i <= level; i++) {
            defis = defis.concat("-");
        }
        return defis;
    }

    public InterItem findItem(String header) {
        InterItem result = null;
        for (InterItem item : list) {
            if (header.equals(item.getHeader())) {
                result = item;
                break;
            }
            result = findItems(item, header);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    private InterItem findItems(InterItem item, String header) {
        InterItem result = null;
        List<InterItem> items = item.getItemIn();
        if (items != null) {
            for (InterItem item1 : items) {
                if (header.equals(item1.getHeader())) {
                    result = item1;
                    break;
                }
                result = findItems(item1, header);
            }
        }
        return result;
    }
}
