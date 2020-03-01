package ru.job4j.calc;

import ru.job4j.calculator.Calculator;
import java.util.Scanner;

public class InteractCalc {
    static Scanner scanner = new Scanner(System.in);

    /**
     * This method calculators the result of operation between two numbers.
     * @param args
     */
    public static void main(String[] args) {
        String enter = "b";
        double result = 0;
        double num1 = 0;
        double num2 = 0;
        char operation;

        while (!enter.equals("e")) {
            if (enter.equals("b")) {
                num1 = getDouble();
                num2 = getDouble();
                operation = getOperation();
            } else {
                num1 = result;
                operation = getOperation();
                num2 = getDouble();
            }
            result = calc(num1, num2, operation);
            System.out.println("Выберите последующее действие:");
            System.out.println("b - начать сначала");
            System.out.println("c - продолжить");
            System.out.println("e - выход");
            if (scanner.hasNext()) {
                enter = scanner.next();
            }
        }
    }

    /**
     * This method gets a number from console.
     * @return - a number of the type double
     */
    public static double getDouble() {
        System.out.println("Введите число:");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getDouble();
        }
        return num;
    }

    /**
     * This method gets a operation from console.
     * @return - the operation
     */
    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    /**
     * This method performs operations on numbers
     * @param num1 - the first number
     * @param num2 - the second number
     * @param operation - operation to be performed
     * @return - the result of operation
     */
    public static double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = Calculator.add(num1, num2);
                break;
            case '-':
                result = Calculator.subtrack(num1, num2);
                break;
            case '*':
                result = Calculator.multiply(num1, num2);
                break;
            case '/':
                result = Calculator.div(num1, num2);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
