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
    public static double add(double first, double second) {
        double result =  first + second;
        System.out.println(first + " + " + second + " = " + result);
        return result;
    }

    /**
     * Method div выполняет деление двух чисел
     * @param first делимое
     * @param second делитель
     */
    public static double div(double first, double second) {
        double result =  first / second;
        System.out.println(first + " / " + second + " = " + result);
        return result;
    }

    /**
     * Method multiply выполняет умножение двух чисел
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static double multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + " * " + second + " = " + result);
        return result;
    }

    /**
     * Method subtrack выполняет операцию вычитания
     * @param first уменьшаемое
     * @param second вычитаемое
     */
    public static double subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + " - " + second + " = " + result);
        return result;
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
