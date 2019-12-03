package ru.job4j.generic;

public class Role<T> extends Base {

    private String description;

    protected Role(String id, String desc) {
        super(id);
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}
