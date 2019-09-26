package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean flag = false;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                flag = data[i];
            } else
                if (data[i] != flag) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}
