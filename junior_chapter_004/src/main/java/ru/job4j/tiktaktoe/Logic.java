package ru.job4j.tiktaktoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class Logic {
    private final Figure[][] table;
    private Graphics graphics;
    private ISize fieldSize;
    private IKindOfGame kindOfGame;

    public Logic(ISize fieldSize, IKindOfGame kindOfGame) {
        int size = fieldSize.getSize();
        this.table = new Figure[size][size];
        this.graphics = new Graphics(table);
        this.fieldSize = fieldSize;
        this.kindOfGame = kindOfGame;
    }

    public void startGame(Scanner scan, int repeatWin) {
        int count = 0;
        char winner = 'I';                // I - инициализация
        while (count < repeatWin) {
            char win = gamePlay(scan);
            if (win == 'D') {            // Draw - ничья
                count = 1;
                continue;
            }
            if (win == winner) {
                count++;
            } else {
                winner = win;
                count = 1;
            }
        }
    }

    private char gamePlay(Scanner scan) {
        char winner = 'D';
        graphics.initGrid();
        graphics.buildGrid();
        while (hasGap()) {
            kindOfGame.moveX(this, scan);
            graphics.buildGrid();
            if (isWinnerX(fieldSize)) {
                System.out.println("Крестики победили!");
                winner = 'X';
                break;
            }
            if (!hasGap()) {
                break;
            }
            kindOfGame.move0(this, scan);
            graphics.buildGrid();
            if (isWinnerO(fieldSize)) {
                System.out.println("Нолики победили!");
                winner = 'O';
                break;
            }
        }
        if (winner == 'D') {
            System.out.println("Игра окончена. Ничья.");
        }
        return winner;
    }

    public boolean fill(Predicate<Figure> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != table.length; index++) {
            Figure cell = table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void moveBot(boolean markX) {
        printWhoMoving(markX);
        int goal = getMoveOpponent();
        int k = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                k++;
                if (k == goal) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        Figure cell = table[x][y];
        cell.take(markX);
    }

    public void movePlayer(Scanner scan, Boolean markX) {
        printWhoMoving(markX);
        System.out.println("Введите индекс ряда:");
        int x = scan.nextInt();
        System.out.println("Введите индекс колонки:");
        int y = scan.nextInt();
        Figure cell = table[x][y];
        cell.take(markX);
    }

    private void printWhoMoving(Boolean markX) {
        if (markX) {
            System.out.println("Ходят крестики:");
        } else {
            System.out.println("Ходят нолики:");
        }
    }

    public Boolean isWinnerX(ISize fieldSize) {
        return fieldSize.winX(this);
    }

    public boolean isWinnerO(ISize fieldSize) {
        return fieldSize.win0(this);
    }

    public boolean hasGap() {
        boolean result = false;
        for (Figure[] figures : table) {
            for (int j = 0; j < table.length; j++) {
                Figure cell = figures[j];
                if (!cell.hasO() && !cell.hasX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private int getMoveOpponent() {
        int[] count = collectAllGaps();
        int randomNum = ThreadLocalRandom.current().nextInt(0, count.length);
        return count[randomNum];
    }

    private int[] collectAllGaps() {
        int[] count = new int[table.length * table.length];
        int k = -1;
        int index = 0;
        for (Figure[] figures : table) {
            for (int j = 0; j < table.length; j++) {
                k++;
                if (!figures[j].hasO() && !figures[j].hasX()) {
                    count[index] = k;
                    index++;
                }
            }
        }
        return Arrays.copyOf(count, index);
    }
}

