package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int row = 0;
        int cell = 0;
        int[][] array = new int[rows][cells];
        for (Integer i : list) {
            array[row][cell] = i;
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}
