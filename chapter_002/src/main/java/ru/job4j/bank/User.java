package ru.job4j.bank;

import java.util.Objects;

public class User {
    private String name;
    private String passport;

    public User(String aName, String aPassport) {
        name = aName;
        passport = aPassport;
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
        return name.equals(user.name) && passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }
}
