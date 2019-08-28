package ru.job4j.condition;

import java.util.Scanner;

public class MyBot {

    public static void main(String[] args) {

        System.out.println("Bot is up.");
        Scanner in = new Scanner(System.in);
        String phrase = in.nextLine();
        DummyBot Bot = new DummyBot();
        String answerBot = Bot.answer(phrase);
        System.out.println(answerBot);
    }
}
