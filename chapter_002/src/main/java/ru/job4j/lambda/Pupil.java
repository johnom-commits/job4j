package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pupil {
    private String surname;

    public Pupil(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public static Map<String, Pupil> listPupil(List<Pupil> list) {
        return list.stream().collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }
}
