package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
       return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }
    public static void main(String[] args) {

        int expected = 2;
        int euro = rubleToEuro(140);
        boolean passed = euro == expected;
        System.out.println("140 rubles are " + euro + " euro. Test result: " + passed);

        int expectedDollar = 2;
        int dollar = rubleToDollar(140);
        passed = dollar == expectedDollar;
        System.out.println("140 rubles are " + dollar + " dollar. Test result: " + passed);

        int expectedEuro = 700;
        int rubleFromEuro = euroToRuble(10);
        passed = rubleFromEuro == expectedEuro;
        System.out.println("10 euro are " + rubleFromEuro + " rubles. Test result: " + passed);

        int expectedRuble = 600;
        int rubleFromDollar = dollarToRuble(10);
        passed = rubleFromDollar == expectedRuble;
        System.out.println("10 dollar are " + rubleFromDollar + " rubles. Test result: " + passed);
    }
}
