package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int index = 0;
        int indexL = 0;
        int indexR = 0;
        while (index < rsl.length) {
            if (indexL < left.length && indexR < right.length && left[indexL] < right[indexR]) {
                rsl[index] = left[indexL];
                indexL++;
            } else if (indexL < left.length && indexR < right.length && left[indexL] >= right[indexR]) {
                rsl[index] = right[indexR];
                indexR++;
            } else if (indexL == left.length) {
                rsl[index] = right[indexR];
                indexR++;
            } else if (indexR == right.length) {
                rsl[index] = left[indexL];
                indexL++;
            }
            index++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int k = 0;
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
