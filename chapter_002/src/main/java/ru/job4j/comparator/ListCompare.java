package ru.job4j.comparator;

import java.util.Comparator;
import static java.lang.Math.min;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = min(left.length(), right.length());
        char[] charLeft = left.toLowerCase().toCharArray();
        char[] charRight = right.toLowerCase().toCharArray();
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Character.compare(charLeft[i], charRight[i]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = charLeft.length - charRight.length;
        }
        return result;
    }
}