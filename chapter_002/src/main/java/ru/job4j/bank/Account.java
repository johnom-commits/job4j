package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(double aValue, String aReguisites) {
        value = aValue;
        requisites = aReguisites;
    }

    public String getRequisites() {
        return requisites;
    }

    public double getValue() {
        return value;
    }

    public boolean credit(double sum) {
        if (sum > value) {
            return false;
        }
        value -= sum;
        return true;
    }

    public void debit(double sum) {
        value += sum;
    }
}
