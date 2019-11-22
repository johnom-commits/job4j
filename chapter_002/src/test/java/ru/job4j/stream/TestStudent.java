package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestStudent {
    @Test
    public void returnListOfStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", 40));
        list.add(new Student("Oleg", 90));
        list.add(new Student("Dima", 70));
        list.add(null);
        list.add(new Student("Vova", 100));
        List<Student> result = Student.levelOf(list, 50);
        assertThat(result.size(), is(3));
    }
}
