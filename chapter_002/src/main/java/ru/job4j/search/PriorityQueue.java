package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            int i = 0;
            while (tasks.get(i).getPriority() < task.getPriority()) {
                i++;
            }
            tasks.add(i, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
