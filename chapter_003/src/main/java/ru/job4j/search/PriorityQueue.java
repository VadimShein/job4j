package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index;
        int taskSize = tasks.size();
        if (taskSize == 0) {
            index = 0;
        } else if (taskSize < task.getPriority()) {
            index = taskSize - 1;
        } else {
            index = task.getPriority() - 1;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}