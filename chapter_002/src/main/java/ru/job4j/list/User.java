package ru.job4j.list;

public class User {
    private int id;
    private String name;
    private String sity;

    public User(int id, String name, String sity) {
        this.id = id;
        this.name = name;
        this.sity = sity;
    }

    public int getId() {
        return this.id;
    }
}
