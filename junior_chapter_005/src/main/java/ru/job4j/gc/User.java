package ru.job4j.gc;

public class User {
    private String firstName;
    private String secondName;

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
}
