package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void whenStudentVisitedSections() {

        Student2 st1 = new Student2("Атос", Set.of("Рукопашный бой", "Танцы", "Фехтование"));
        Student2 st2 = new Student2("Портос", Set.of("Стрельба", "Фехтование", "Верховая езда"));
        Student2 st3 = new Student2("Арамис", Set.of("Стрельба", "Танцы"));
        Student2 st4 = new Student2("Д'артаньян", Set.of("Рукопашный бой", "Верховая езда"));
        List<Student2> list = List.of(st1, st2, st3, st4);
        Map<String, Set<String>> result = Group.sections(list);

        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("Рукопашный бой", Set.of("Атос", "Д'артаньян"));
        expected.put("Танцы", Set.of("Атос", "Арамис"));
        expected.put("Фехтование", Set.of("Атос", "Портос"));
        expected.put("Стрельба", Set.of("Портос", "Арамис"));
        expected.put("Верховая езда", Set.of("Портос", "Д'артаньян"));

        assertThat(result, is(expected));
    }

}