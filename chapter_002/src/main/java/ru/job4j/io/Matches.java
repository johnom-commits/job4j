package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        int counter = 0;
        String player = "";
        while (count > 0) {
            counter++;
            if (counter % 2 == 0) {
                player = "Второй игрок: ";
            } else {
                player = "Первый игрок: ";
            }
            System.out.println(player);
            int matches = Integer.valueOf(input.nextLine());
            if (matches < 1 || matches > 3 || matches > count) {
                System.out.println("Число спичек выбрано неверно. Попробуйте еще раз.");
                counter--;
                continue;
            }
            count = count - matches;
            System.out.println("Осталось карт: " + count);
        }
        System.out.println("Игра окончена. Выиграл " + player);
    }
}
