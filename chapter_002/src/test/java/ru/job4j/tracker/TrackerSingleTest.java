package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.singleton.TrackerSingle;
import ru.job4j.singleton.TrackerSingle2;
import ru.job4j.singleton.TrackerSingle3;
import ru.job4j.singleton.TrackerSingle4;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {
    @Test
    public void checkSingleton() {
        TrackerSingle trac = TrackerSingle.INSTANCE;
        TrackerSingle trac2 = TrackerSingle.INSTANCE;
        boolean result = trac.equals(trac2);
        assertThat(result, is(true));
    }

    @Test
    public void checkSingleton2() {
        TrackerSingle2 trac = TrackerSingle2.getInstance();
        TrackerSingle2 trac2 = TrackerSingle2.getInstance();
        boolean result = trac.equals(trac2);
        assertThat(result, is(true));
    }

    @Test
    public void checkSingleton3() {
        TrackerSingle3 trac = TrackerSingle3.getInstance();
        TrackerSingle3 trac2 = TrackerSingle3.getInstance();
        boolean result = trac.equals(trac2);
        assertThat(result, is(true));
    }

    @Test
    public void checkSingleton4() {
        TrackerSingle4 trac = TrackerSingle4.getInstance();
        TrackerSingle4 trac2 = TrackerSingle4.getInstance();
        boolean result = trac.equals(trac2);
        assertThat(result, is(true));
    }
}
