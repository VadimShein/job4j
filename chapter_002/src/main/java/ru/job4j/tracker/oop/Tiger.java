package ru.job4j.tracker.oop;

public class Tiger extends Predator {
    public Tiger() {
        System.out.println("load Tiger");
    }
    public Tiger(String name) {
        super(name);
        System.out.println("load Tiger; string");
    }
}
