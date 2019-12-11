package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenTwoUser() {
        User user1 = new User("Policarp", 2, new GregorianCalendar(1908, 11, 10));
        User user2 = new User("Policarp", 2, new GregorianCalendar(1908, 11, 10));
        Map<User, String> map = new HashMap<>(4);
        map.put(user1, "Sharikov");
        map.put(user2, "Chugunkin");
        System.out.println(map);
    }

}