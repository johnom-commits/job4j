package ru.job4j.menu;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.showMenu();
    }

    private void showMenu() {
        Menu menu = new Menu();
        InterItem item1 = new Item("Пункт_1", "Пункт 1", new DoSomething());
        InterItem item11 = new Item("Пункт_1_1", "Пункт 1.1", new DoSomething2());
        InterItem item12 = new Item("Пункт_1_2", "Пункт 1.2", new DoSomething3());
        item1.addSubItems(List.of(item11, item12));
        InterItem item121 = new Item("Пункт_1_2_1", "Пункт 1.2.1", new DoSomething());
        InterItem item122 = new Item("Пункт_1_2_2", "Пункт 1.2.2", new DoSomething2());
        item12.addSubItems(List.of(item121, item122));

        InterItem item2 = new Item("Пункт_2", "Пункт 2", new DoSomething3());
        menu.add(item1);
        menu.add(item2);
        menu.show();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню:");
        if (scanner.hasNext()) {
            String choiceItem = scanner.nextLine();
            InterItem item = menu.findItem(choiceItem);
            if (item != null) {
                item.runAction();
            }
        }
    }
}
