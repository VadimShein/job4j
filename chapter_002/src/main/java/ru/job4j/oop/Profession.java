package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name) {
        System.out.println(name);
    }
    public String getName(String name) {
        this.name = name;
        return name;
    }
}