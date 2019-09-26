package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int length = array.length;
        String temp, word;
        for (int i = 0; i < length; i++) {
            word = array[i];
            for (int j = i + 1; j < length; j++) {
                if (word.equals(array[j])) {
                    temp = array[length - 1];
                    array[length - 1] = array[j];
                    array[j] = temp;
                    length--;
                    j--;
                }
            }
        }
        return  Arrays.copyOf(array, length);
    }
}
