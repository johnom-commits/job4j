package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserActionFindTests {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenFindAllAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("new name");
        String[] answers = {item.getName()};
        tracker.add(item);
        FindAllAction findAllAction = new FindAllAction();
        findAllAction.execute(new StubInput(answers), tracker);
        String result = out.toString();
        String expected = new StringBuilder()
                .append("=== All items =====\r\nId: ")
                .append(item.getId())
                .append(", name: ")
                .append(item.getName())
                .append("\r\n")
                .toString();
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindByNameAction() {
        Tracker tracker = new Tracker();
        FindByNameAction action = new FindByNameAction();
        Item item = new Item("new name");
        String[] answers = {item.getName()};
        tracker.add(item);
        action.execute(new StubInput(answers), tracker);
        String result = out.toString();
        String expected = new StringBuilder()
                .append("Item: ")
                .append(item.getId())
                .append("\r\n")
                .toString();
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindByIdAction() {
        Tracker tracker = new Tracker();
        FindByIdAction action = new FindByIdAction();
        Item item = new Item("new name");
        tracker.add(item);
        String[] answers = {item.getId()};
        action.execute(new StubInput(answers), tracker);
        String result = out.toString();
        assertThat(result, is("Item: new name\r\n"));
    }
}
