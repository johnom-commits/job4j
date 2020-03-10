package ru.job4j.menu;

import java.util.List;

public interface InterItem {
    void runAction();

    void addSubItems(List<InterItem> itemList);

    String getHeader();

    List<InterItem> getItemIn();
}
