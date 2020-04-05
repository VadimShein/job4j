package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String organ;

    public Surgeon(String organ) {
        super(organ);
        System.out.println(organ);
    }
    public String getOrgan(String organ) {
        return organ;
    }
}