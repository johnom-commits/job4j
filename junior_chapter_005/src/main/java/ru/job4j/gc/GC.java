package ru.job4j.gc;

public class GC {

    public static void main(String[] args) {
        info();

        for (int i = 0; i < 4100; i++) {
            User user = new User(new String("Vasya"), new String("Pupkin"));
        }
        info();
    }

    private static void info() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("-------------------------------");
        System.out.format("Total: %,8d%n", runtime.totalMemory());
        System.out.format("Free: %,8d%n", runtime.freeMemory());
    }
}
