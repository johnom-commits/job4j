package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        int temp = 0;
//      В первом цикле делаем перестановку в массиве
        for (int j = 0; j < data.length; j++) {
//          Во втором цикле ицщем индекс минимального значения в массиве
            int min = data[j];
            for (int i = j; i < data.length; i++) {
                if (data[i] < min) {
                    min = data[i];
                }
            }
            int indexMin = indexOf(data, min, j, data.length);
            temp = data[j];
            data[j] = data[indexMin];
            data[indexMin] = temp;
        }
        return data;
    }
}
