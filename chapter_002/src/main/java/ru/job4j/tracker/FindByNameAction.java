package ru.job4j.tracker;

public class FindByNameAction extends BaseAction {

    protected FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Please, enter the name:");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item i : items) {
                System.out.println("Item: " + i.getId());
            }
        } else {
            System.out.println("Item does not find.");
        }
        return true;
    }
}
