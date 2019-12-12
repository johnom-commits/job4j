package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Group {

    public static Map<String, Set<String>> sections(List<Student2> students) {
        return students.stream()
                .flatMap(x -> x.getUnits().stream().map(u -> new Holder(u, x.getName())))
                .collect(groupingBy(o -> o.key, mapping(o -> o.value, toSet())));
    }
}