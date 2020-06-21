package ru.job4j.tiktaktoe;

import java.util.Scanner;

public class KindUserBot implements IKindOfGame {
    @Override
    public void moveX(Logic logic, Scanner scan) {
        logic.movePlayer(scan, true);
    }

    @Override
    public void move0(Logic logic, Scanner scan) {
        logic.moveBot(false);
    }
}
