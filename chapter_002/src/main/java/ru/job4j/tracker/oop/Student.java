package ru.job4j.tracker.oop;

@SuppressWarnings("checkstyle:WhitespaceAround")
public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }
    public void song() {
        System.out.println("I belive I can fly");
    }
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();    }
}