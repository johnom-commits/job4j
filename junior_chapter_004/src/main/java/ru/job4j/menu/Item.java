package ru.job4j.menu;

import java.util.List;

public class Item implements InterItem {
    private String name;
    private List<InterItem> itemIn;
    private String header;
    private IMenuAction action;

    public Item(String name, String header, IMenuAction action) {
        this.name = name;
        this.header = header;
        this.action = action;
    }

    public void runAction() {
        action.execute();
    }

    public void addSubItems(List<InterItem> itemList) {
        itemIn = itemList;
    }

    public List<InterItem> getItemIn() {
        return itemIn;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }
}
