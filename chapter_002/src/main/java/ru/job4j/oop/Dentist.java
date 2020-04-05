package ru.job4j.oop;

public class Dentist extends Doctor {
    private String tooth;

    public Dentist(String tooth) {
        super(tooth);
        System.out.println(tooth);
    }
    public String getTooth(String tooth) {
        return tooth;
    }
}