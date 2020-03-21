package ru.job4j.tracker.oop;

public class Engineer extends Profession {
    private String task;

    public Engineer(String task) {
        super(task);
        System.out.println(task);
    }
    public String getTask(String task) {
        return task;
    }
}