package ru.job4j.lsp;

public interface ControlQuality {
    default void sort(IFood food, Storage storage) {
        storage.addFood(food);
    }

    String getName();
}
