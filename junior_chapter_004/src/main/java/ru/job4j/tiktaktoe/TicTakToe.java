package ru.job4j.tiktaktoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TicTakToe {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Крестики-нолики!");
        try (Scanner scan = new Scanner(System.in)) {
            ISize size = showMenu(scan);
            IKindOfGame kind = showMenu2(scan);
            int repeatWin = showMenu3(scan);
            Logic logic = new Logic(size, kind);
            logic.startGame(scan, repeatWin);
        }
    }

    private static ISize showMenu(Scanner scan) {
        Menu menu = new Menu();
        menu.add(new ItemSize(1, "[3 x 3]", new FieldSize3()));
        menu.add(new ItemSize(2, "[4 x 4]", new FieldSize4()));
        menu.add(new ItemSize(3, "[5 x 5]", new FieldSize5()));
        menu.show();
        System.out.println("Выберите размерность игры (номер пункта):");
        ISize fieldSize = null;
        if (scan.hasNextInt()) {
            int item = scan.nextInt();
            ItemSize itemSize = menu.findItem(item);
            fieldSize = itemSize.getFieldSize();
        }
        return fieldSize;
    }

    private static IKindOfGame showMenu2(Scanner scan) {
        MenuKinds menu = new MenuKinds();
        menu.add(new ItemKind(1, "Пользователь - Бот", new KindUserBot()));
        menu.add(new ItemKind(2, "Бот - Пользователь", new KindBotUser()));
        menu.add(new ItemKind(3, "Бот - Бот", new KindBotBot()));
        menu.show();
        System.out.println("Выберите вид игры:");
        IKindOfGame kindOfGame = null;
        if (scan.hasNextInt()) {
            int item = scan.nextInt();
            ItemKind itemKind = menu.findItem(item);
            kindOfGame = itemKind.getKind();
        }
        return kindOfGame;
    }

    private static int showMenu3(Scanner scan) {
        int repeatWin = 1;
        System.out.println("Введите число выиграшей подряд для победы:");
        if (scan.hasNextInt()) {
            repeatWin = scan.nextInt();
        }
        return repeatWin;
    }
}



