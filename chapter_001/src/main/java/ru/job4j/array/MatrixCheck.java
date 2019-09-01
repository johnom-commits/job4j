package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean flag = true;
        boolean flag2 = true;
        int length = data.length - 1;

        flag = data[0][0];
        flag2 = data[length][0];

        for (int i = 0; i <= length; i++) {
            if (flag != data[i][i] || flag2 != data[length - i][i]) {
                result = false;
            }
        }
        return result;
    }
}
