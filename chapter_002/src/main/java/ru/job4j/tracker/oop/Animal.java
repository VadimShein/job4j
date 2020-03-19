package ru.job4j.tracker.oop;

public class Animal {
    public Animal() {
        super();
        System.out.println("load Animal");
    }
    public static void main(String[] args) {
        Predator predator = new Predator();
        Tiger tiger = new Tiger();
    }
}
