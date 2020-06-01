package ru.job4j.menu;

public class DoSomething implements IMenuAction {

    @Override
    public void execute() {
        System.out.println("Hello world");
    }
}
