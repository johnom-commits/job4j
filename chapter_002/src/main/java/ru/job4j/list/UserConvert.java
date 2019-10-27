package ru.job4j.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public static void main(String[] args) {

        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1, "Ivan", "Moscow"));
        list.add(new User(2, "Petr", "Moscow"));
        HashMap<Integer, User> hm = process(list);
    }

    public static HashMap<Integer, User> process(List<User> list) {
        if (!list.isEmpty()) {
            HashMap<Integer, User> hm = new HashMap<>();
            for (User u : list) {
                hm.put(u.getId(), u);
            }
            return hm;
        } else {
            return null;
        }
    }
}
