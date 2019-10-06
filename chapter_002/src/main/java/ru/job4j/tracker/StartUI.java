package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Tracker tracker) {
        Item[] copy = tracker.findAll();
        if (copy.length == 0) {
            System.out.println("There are no items");
        } else {
            System.out.println("=== All items =====");
        }
        for (Item item : copy) {
            System.out.println("Id: " + item.getId() + ", name: " + item.getName());
        }
    }

    public static void replace(Input input, Tracker tracker) {
        String id = input.askStr("Enter Id:");
        String name = input.askStr("Enter new name:");
        Item item = new Item(name);
        item.setId(id);
        Boolean result = tracker.replace(id, item);
        if (result) {
            System.out.println("Done!");
        } else {
            System.out.println("Item does not find");
        }
    }

    public static void delete(Input input, Tracker tracker) {
        String id = input.askStr("Enter Id:");
        Boolean result = tracker.delete(id);
        if (result) {
            System.out.println("Item delete.");
        } else {
            System.out.println("Attempt failed");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        String id = input.askStr("Please, enter Id:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item: " + item.getName());
        } else {
            System.out.println("Item does not find.");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("Please, enter the name:");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item i : items) {
                System.out.println("Item: " + i.getId());
            }
        } else {
            System.out.println("Item does not find.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(tracker);
            } else if (select == 2) {
                StartUI.replace(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
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
