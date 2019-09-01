package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double mustToPay = amount + (amount * percent / 100);
        while (mustToPay > 0) {
            mustToPay -= 12 * monthly;
            year++;
        }
        return year;
    }
}
