package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] copy = tracker.findAll();
        if (copy.length == 0) {
            System.out.println("There are no items");
        } else {
            System.out.println("=== All items =====");
        }
        for (Item item : copy) {
            System.out.println("Id: " + item.getId() + ", name: " + item.getName());
        }
        return true;
    }
}
