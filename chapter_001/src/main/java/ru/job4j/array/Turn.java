package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int aLength = array.length - 1;
        for (int i = 0; i <= aLength/2; i++) {
            int temp = array[i];
            array[i] = array[aLength - i];
            array[aLength - i] = temp;
        }
        return array;
    }
}
