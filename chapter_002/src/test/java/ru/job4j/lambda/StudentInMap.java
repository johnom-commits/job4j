package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentInMap {
    @Test
    public void whenStudentInMap() {
        final List<Pupil> list = new ArrayList<>();
        Pupil pupil = new Pupil("Ivanov");
        list.add(pupil);
        Pupil pupil2 = new Pupil("Sokolov");
        list.add(pupil2);

        Map<String, Pupil> result = list.stream().collect(Collectors.toMap(e -> e.getSurname(), e -> e));
        Map<String, Pupil> expected = new HashMap<>();
        expected.put(pupil.getSurname(), pupil);
        expected.put(pupil2.getSurname(), pupil2);
        assertThat(result, is(expected));
    }
}
