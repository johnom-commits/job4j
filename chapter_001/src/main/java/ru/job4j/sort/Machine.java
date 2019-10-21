package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int remainder = money - price;
        if (remainder > 0) {
            for (int i : COINS) {
                while ((remainder - i) >= 0) {
                    remainder -= i;
                    rsl[size] = i;
                    size++;
                }
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
