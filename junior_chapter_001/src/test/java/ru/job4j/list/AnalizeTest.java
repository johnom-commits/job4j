package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAddNewUser() {
        Analize.User user1 = new Analize.User(1, "Alina");
        Analize.User user2 = new Analize.User(2, "Anya");
        Analize.User user3 = new Analize.User(3, "Alena");

        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);

        List<Analize.User> current = new ArrayList<>();
        current.add(user1);
        current.add(user2);
        current.add(user3);

        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);

        assertEquals(info.added, 1);
    }

    @Test
    public void whenDeleteUser() {
        Analize.User user1 = new Analize.User(1, "Alina");
        Analize.User user2 = new Analize.User(2, "Anya");

        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);

        List<Analize.User> current = new ArrayList<>();
        current.add(user1);

        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);

        assertEquals(info.deleted, 1);
    }

    @Test
    public void whenChangeUser() {
        Analize.User user1 = new Analize.User(1, "Alina");
        Analize.User user2 = new Analize.User(2, "Anya");

        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);

        List<Analize.User> current = new ArrayList<>();
        current.add(user1);
        Analize.User user2Change = new Analize.User(2, "Alyana");
        current.add(user2Change);

        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);

        assertEquals(info.changed, 1);
    }
}