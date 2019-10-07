package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
