package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private List<Student> returnList() {
        final List<Student> list = new ArrayList<>();
        list.add(new Student(100));
        list.add(new Student(90));
        list.add(new Student(70));
        list.add(new Student(80));
        list.add(new Student(50));
        list.add(new Student(40));
        list.add(new Student(30));
        return list;
    }

    @Test
    public void whenClassA() {
        School school = new School();
        List<Student> result = school.collect(returnList(), student -> student.getScore() >= 70);
        int expected = 4;
        assertThat(result.size(), is(4));
    }

    @Test
    public void whenClassB() {
        School school = new School();
        List<Student> result = school.collect(returnList(), student -> student.getScore() < 70 && student.getScore() >= 50);
        int expected = 1;
        assertThat(result.size(), is(1));
    }

    @Test
    public void whenClassC() {
        School school = new School();
        List<Student> result = school.collect(returnList(), student -> student.getScore() < 50);
        int expected = 2;
        assertThat(result.size(), is(2));
    }
}
