package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<IFood> foodList = new ArrayList<>();

    public void addFood(IFood food) {
        foodList.add(food);
    }

    public List<IFood> getFoodList() {
        return foodList;
    }
}
