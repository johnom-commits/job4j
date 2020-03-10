package ru.job4j.menu;

public class doSomething implements IMenuAction {

    @Override
    public void execute() {
        System.out.println("Hello world");
    }
}
