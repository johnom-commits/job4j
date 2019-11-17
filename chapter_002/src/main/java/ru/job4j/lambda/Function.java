package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

public class Function {
    public static List<Double> diapason(double start, double finish, DoubleFunction<Double> op) {
        List<Double> list = new ArrayList<>();
        for (double index = start; index != finish; index++) {
            list.add(op.apply(index));
        }
        return list;
    }
}
