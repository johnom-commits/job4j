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

    public void setValue(double aValue) {
        value = aValue;
    }

    public boolean transfer(double sum, Account destAccount) {
        if (sum > value) {
            return false;
        }
        value -= sum;
        double destValue = destAccount.getValue();
        destValue += sum;
        destAccount.setValue(destValue);
        return true;
    }
}
