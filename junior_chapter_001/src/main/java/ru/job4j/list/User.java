package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private List<String> email = new ArrayList<>();

    public User(int id) {
        this.id = id;
    }

    public List<String> getEmail() {
        return email;
    }

    public void addEmail(String aEmail) {
        email.add(aEmail);
    }

    public void clearEmail() {
        email.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        for (var e : email) {
            result = result + e.hashCode();
        }
        return result;
    }
}
