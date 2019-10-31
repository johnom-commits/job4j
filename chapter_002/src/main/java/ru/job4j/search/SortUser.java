package ru.job4j.search;

import java.util.*;

public class SortUser {
    public static void main(String[] args) {
        List<User> list = new ArrayList();
        list.add(new User(33, "Ivan"));
        list.add(new User(40, "Dermidont"));
        list.add(new User(30, "Vova"));
        list.add(new User(29, "Porfiriy"));
        list.add(new User(37, "Dermidont"));
        List<User> us = sortNameLength(list);
        show(us);
        List<User> us2 = sortByAllFields(list);
        show(us2);
    }

    public static List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }.thenComparing(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        }));
        return list;
    }

    public static List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }

    private static void show(List<User> list) {
        for (User u : list) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
        System.out.println();
    }
}
