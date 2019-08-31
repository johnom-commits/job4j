package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean flag = true;
        boolean flag2 = true;
        int length = data.length - 1;

        for (int i = 0; i <= length; i++) {
            if (i == 0) {
                flag = data[i][i];
                flag2 = data[length - i][i];
            } else
            {
                if (flag != data[i][i] || flag2 != data[length - i][i]) {
                    result = false;
                }
            }
        }
        return result;
    }
}
