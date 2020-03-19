package ru.job4j.tracker.oop;

public class Predator extends Animal {
    public Predator() {
        System.out.println("load Predator");
    }
    public Predator(String name) {
        super(name);
        System.out.println("load Predator; string");
    }
}
