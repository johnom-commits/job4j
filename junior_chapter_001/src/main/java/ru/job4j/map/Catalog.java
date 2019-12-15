package ru.job4j.map;
// 9.1. Рассказать и продемонстрировать как переопределяют метод hashCode[#202198] (по Блоху)

import java.util.Objects;

public class Catalog {
    private int id;
    private String description;
    private User user;

    public Catalog(int id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog) o;
        return id == catalog.id
                && Objects.equals(description, catalog.description)
                && Objects.equals(user, catalog.user);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        if (description != null) {
            result = 31 * result + description.hashCode();
        }
        if (user != null) {
            result = 31 * result + user.hashCode();
        }
        return result;
    }
}
