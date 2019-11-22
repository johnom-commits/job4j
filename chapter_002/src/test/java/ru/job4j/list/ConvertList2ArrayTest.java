package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when4Elements() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 4}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertList() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> list = List.of(
                        new int[]{1, 2},
                        new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
}