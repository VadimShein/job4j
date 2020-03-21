package ru.job4j.tracker.oop;

public class Builder extends Engineer {
    private String object;

    public Builder(String object) {
        super(object);
        System.out.println(object);
    }
    public String getCode(String object) {
        return object;
    }
}