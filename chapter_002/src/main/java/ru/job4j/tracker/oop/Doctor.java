package ru.job4j.tracker.oop;

public class Doctor extends Profession {
    private String diagnose;

    public Doctor(String diagnose) {
        super(diagnose);
        System.out.println(diagnose);
    }
    public String getDiagnose(String diagnose) {
        return diagnose;
    }
}