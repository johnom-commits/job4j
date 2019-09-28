package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.print("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.print("Спокойной ночи");
        } else {
            System.out.print("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
    }
}
