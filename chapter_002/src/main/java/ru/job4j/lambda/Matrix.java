package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    public static List<Integer> transform(Integer[][] array) {
        return Arrays.stream(array).flatMap(integers -> Arrays.stream(integers)).collect(Collectors.toList());
    }
}
