package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length - 1);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0, "Add a new item"),
                new FindAllAction(1, "Show all items"),
                new ReplaceAction(2, "Edit item"),
                new DeleteAction(3, "Delete item"),
                new FindByIdAction(4, "Find item by Id"),
                new FindByNameAction(5, "Find items by name"),
                new ExitAction(6, "Exit program")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
