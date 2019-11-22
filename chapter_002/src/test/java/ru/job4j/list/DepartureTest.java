package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartureTest {
    @Test
    public void whenFillGapsAndAbs() {
        List<String> list = new ArrayList<>();
        list.add("K1/SK1");
        list.add("K1/SK2");
        list.add("K1/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2");
        list.add("K2/SK1/SSK1");
        list.add("K2/SK1/SSK2");

        Departure departure = new Departure();
        departure.fillGaps(list);
        departure.abs(list);

        List<String> expected = List.of(
            "K1",
            "K1/SK1",
            "K1/SK1/SSK1",
            "K1/SK1/SSK2",
            "K1/SK2",
            "K2",
            "K2/SK1",
            "K2/SK1/SSK1",
            "K2/SK1/SSK2");
        assertThat(list, is(expected));
    }

    @Test
    public void whenFillGapsAndDesc() {
        List<String> list = new ArrayList<>();
        list.add("K1/SK1");
        list.add("K1/SK2");
        list.add("K1/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2");
        list.add("K2/SK1/SSK1");
        list.add("K2/SK1/SSK2");

        Departure departure = new Departure();
        departure.fillGaps(list);
        departure.desc(list);

        List<String> expected = List.of(
        "K2",
        "K2/SK1",
        "K2/SK1/SSK2",
        "K2/SK1/SSK1",
        "K1",
        "K1/SK2",
        "K1/SK1",
        "K1/SK1/SSK2",
        "K1/SK1/SSK1");
        assertThat(list, is(expected));
    }
}
