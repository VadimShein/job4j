package ru.job4j.oop;

public class Animal {
    public Animal() {
        System.out.println("load Animal");
    }
    public Animal(String name) {
        System.out.println("load Animal; string");
    }
    public static void main(String[] args) {
        Predator predator = new Predator();
        Tiger tiger = new Tiger();
        Tiger tiger2 = new Tiger("myTiger");
    }
}
