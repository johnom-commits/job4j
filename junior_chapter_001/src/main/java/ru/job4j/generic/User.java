package ru.job4j.generic;

public class User<T> extends Base {

    private String name;

    protected User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
