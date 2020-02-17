package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    @Test
    public void whenCreateItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(StartUISQL.init()))) {
            tracker.add(new Item("name"));
            assertEquals(1, tracker.findByName("name").size());
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(StartUISQL.init()))) {
            Item item = new Item("to be or not to be what is the question");
            tracker.add(item);
            tracker.delete(item.getId());
            assertEquals(0, tracker.findByName("to be or not to be what is the question").size());
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(StartUISQL.init()))) {
            int beforeSize = tracker.findAll().size();
            Item item = new Item("new test");
            tracker.add(item);
            assertEquals(beforeSize + 1, tracker.findAll().size());
        }
    }
}