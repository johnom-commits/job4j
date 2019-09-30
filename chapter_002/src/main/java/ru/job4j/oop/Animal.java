package ru.job4j.oop;

public class Animal {
    public String name;

    public Animal(String name) {
        super();
        this.name = name;
        System.out.println("load Animal");
    }
    public static void main(String[] args) {
        Tiger tiger = new Tiger("Уссурийский тигр");
    }
}
