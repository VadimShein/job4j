package ru.job4j.oop;

public class Programmer extends Engineer {
    private String code;

    public Programmer(String code) {
        super(code);
        System.out.println(code);
    }
    public String getCode(String code) {
        return code;
    }
}