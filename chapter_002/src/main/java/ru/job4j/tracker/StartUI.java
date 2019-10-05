package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] copy = tracker.findAll();
                if (copy.length == 0) {
                    System.out.println("There are no items");
                } else {
                    System.out.println("=== All items =====");
                }
                for (Item item : copy) {
                    System.out.println("Id: " + item.getId() + ", name: " + item.getName());
                }
            } else if (select == 2) {
                String id = input.askStr("Enter Id:");
                String name = input.askStr("Enter new name:");
                Item item = new Item(name);
                Boolean result = tracker.replace(id, item);
                if (result) {
                    System.out.println("Done!");
                } else {
                    System.out.println("Item does not find");
                }
            } else if (select == 3) {
                String id = input.askStr("Enter Id:");
                Boolean result = tracker.delete(id);
                if (result) {
                    System.out.println("Item delete.");
                } else {
                    System.out.println("Attempt failed");
                }
            } else if (select == 4) {
                String id = input.askStr("Please, enter Id:");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Item: " + item.getName());
                } else {
                    System.out.println("Item does not find.");
                }
            } else if (select == 5) {
                String name = input.askStr("Please, enter the name:");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (Item i : items) {
                        System.out.println("Item: " + i.getId());
                    }
                } else {
                    System.out.println("Item does not find.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
