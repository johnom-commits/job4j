package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void whenUserStoreAdd() {
        UserStore list = new UserStore();
        User user1 = new User("00001", "Ivan");
        list.add(user1);
        User user2 = new User("00002", "Boris");
        list.add(user2);
        User user3 = new User("00003", "Vova");
        list.add(user3);

        assertThat(list.findById("00002"), is(user2));
    }

    @Test
    public void whenUserDelete() {
        UserStore list = new UserStore();
        User user1 = new User("00001", "Ivan");
        list.add(user1);
        User user2 = new User("00002", "Boris");
        list.add(user2);
        User user3 = new User("00003", "Vova");
        list.add(user3);

        list.delete("00002");

        assertThat(list.size(), is(2));
    }

    @Test
    public void whenUserReplace() {
        UserStore list = new UserStore();
        User user1 = new User("00001", "Ivan");
        list.add(user1);
        User user2 = new User("00002", "Boris");
        list.add(user2);
        User user3 = new User("00003", "Vova");
        list.add(user3);

        User newUser = new User("00005", "Makar");

        list.replace("00002", newUser);

        assertThat(list.findById("00005").getName(), is("Makar"));
    }
}