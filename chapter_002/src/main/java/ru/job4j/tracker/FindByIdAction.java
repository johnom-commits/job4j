package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Please, enter Id:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item: " + item.getName());
        } else {
            System.out.println("Item does not find.");
        }
        return true;
    }
}
