package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter Id:");
        Boolean result = tracker.delete(id);
        if (result) {
            System.out.println("Item delete.");
        } else {
            System.out.println("Attempt failed");
        }
        return true;
    }
}
