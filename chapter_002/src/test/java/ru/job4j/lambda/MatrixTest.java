package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenMatrixInList() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> result = Matrix.transform(matrix);
        List<Integer> expected = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        assertThat(result, is(expected));
    }

}
