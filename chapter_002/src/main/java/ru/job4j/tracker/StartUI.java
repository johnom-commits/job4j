package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size() - 1);
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
                actions.add(new CreateAction(0, "Add a new item"));
                actions.add(new FindAllAction(1, "Show all items"));
                actions.add(new ReplaceAction(2, "Edit item"));
                actions.add(new DeleteAction(3, "Delete item"));
                actions.add(new FindByIdAction(4, "Find item by Id"));
                actions.add(new FindByNameAction(5, "Find items by name"));
                actions.add(new ExitAction(6, "Exit program"));
        new StartUI().init(validate, tracker, actions);
    }
}
