package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int i = 0;
        for (int row = 0; row < rows; row++) {
            for (int cell = 0; cell < cells; cell++) {
                if (i < list.size()) {
                    array[row][cell] = list.get(i);
                    i++;
                } else {
                    array[row][cell] = 0;
                }
            }
        }
        return array;
    }
}
