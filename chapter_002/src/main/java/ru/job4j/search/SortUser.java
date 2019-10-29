package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public static void main(String[] args) {
        List<User> list = new ArrayList();
        list.add(new User(33, "Ivan"));
        list.add(new User(30, "Boris"));
        list.add(new User(29, "Gleb"));
        Set<User> userSet = sort(list);
        for (User u : userSet) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
    }

    public static Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>(list);
        return set;
    }
}
