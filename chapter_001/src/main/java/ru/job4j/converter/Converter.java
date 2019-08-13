package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
       return value / 60;
    }

    public static int EuroToRuble(int value) {
        return value * 70;
    }

    public static int DollarToRuble(int value) {
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
        int RubleFromEuro = EuroToRuble(10);
        passed = RubleFromEuro == expectedEuro;
        System.out.println("10 euro are " + RubleFromEuro + " rubles. Test result: " + passed);

        int expectedRuble = 600;
        int RubleFromDollar = DollarToRuble(10);
        passed = RubleFromDollar == expectedRuble;
        System.out.println("10 dollar are " + RubleFromDollar + " rubles. Test result: " + passed);
    }
}
