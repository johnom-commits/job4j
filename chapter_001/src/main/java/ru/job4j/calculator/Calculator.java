package ru.job4j.calculator;
/**
 * Class Calculator для выполнения арифметических операций
 * @author Евгений Омельченко
 * @since 30.08.2019
 * @version 1.0
 */
public class Calculator {
    /**
     * Method add выполняет сложение двух чисел
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * Method div выполняет деление двух чисел
     * @param first делимое
     * @param second делитель
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Method multiply выполняет умножение двух чисел
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Method subtrack выполняет операцию вычитания
     * @param first уменьшаемое
     * @param second вычитаемое
     */
    public static void subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Method main
     * @param args аргументы
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}
