package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class MergeUsersTest {

    @Test
    public void whenMergeUsers() {

        User user1 = new User(1);
        user1.addEmail("xxx@ya.ru");
        user1.addEmail("foo@gmail.com");
        user1.addEmail("lol@mail.ru");

        User user2 = new User(2);
        user2.addEmail("foo@gmail.com");
        user2.addEmail("ups@pisem.net");

        User user3 = new User(3);
        user3.addEmail("xyz@pisem.net");
        user3.addEmail("vasya@pupkin.com");

        User user4 = new User(4);
        user4.addEmail("ups@pisem.net");
        user4.addEmail("aaa@bbb.ru");

        User user5 = new User(5);
        user5.addEmail("xyz@pisem.net");

        List<User> previous = Arrays.asList(user1, user2, user3, user4, user5);
        List<User> newUsers = MergeUsers.merge(previous);

        User newUser4 = new User(4);
        newUser4.addEmail("aaa@bbb.ru");
        newUser4.addEmail("ups@pisem.net");
        newUser4.addEmail("lol@mail.ru");
        newUser4.addEmail("xxx@ya.ru");
        newUser4.addEmail("foo@gmail.com");

        User newUser5 = new User(5);
        newUser5.addEmail("vasya@pupkin.com");
        newUser5.addEmail("xyz@pisem.net");

        List<User> expected = Arrays.asList(newUser4, newUser5);

        assertThat(newUsers, is(expected));
    }
}