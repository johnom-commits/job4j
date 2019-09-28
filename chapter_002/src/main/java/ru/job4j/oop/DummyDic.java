package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String exp = "Неизвестное слово." + eng;
        return exp;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String rus = dic.engToRus("java");
        System.out.print(rus);
    }
}
