package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}