package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
        @Override
        public String toString() {
            return out.toString();
            }
        };

    @Test
    public void doneInit() {
        Input input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction(0, "Stub action");
        List<UserAction> list = new ArrayList<>();
        list.add(action);
        new StartUI(input, new Tracker(), System.out::println).init(list);
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenPrtMenu() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction(0, "Stub action");
        List<UserAction> list = new ArrayList<>();
        list.add(action);
        new StartUI(input, new Tracker(), output).init(list);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(this.out.toString(), is(expect));
    }
}


