package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Item second = new Item("test2");
        tracker.add(second);
        Item third = new Item("test3");
        tracker.add(third);
        List<Item> copy = tracker.findAll();
        assertThat(copy.size(), is(3));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Item second = new Item("test2");
        tracker.add(second);
        Item third = new Item("test2");
        tracker.add(third);
        List<Item> copy = tracker.findByName("test2");
        assertThat(copy.size(), is(2));
    }
    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        String id = item.getId();
        assertThat(tracker.findById(id).getId(), is(id));
    }
    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Item second = new Item("test2");
        tracker.add(second);
        Item third = new Item("test3");
        tracker.add(third);
        tracker.delete(second.getId());
        List<Item> copy = tracker.findAll();
        assertThat(copy.size(), is(2));
    }
    @Test
    public void testDeleteFirstItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        tracker.add(first);
        Item second = new Item("test2");
        tracker.add(second);
        Item third = new Item("test3");
        tracker.add(third);
        Item forth = new Item("test4");
        tracker.add(forth);
        tracker.delete(first.getId());
        List<Item> copy = tracker.findAll();
        assertThat(copy.size(), is(3));
    }
}
