package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted().takeWhile(s -> s.scope >= bound).collect(Collectors.toList());
    }

    @Override
    public int compareTo(Student o) {
        return o.scope - this.scope;
    }
}
