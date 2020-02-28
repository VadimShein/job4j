package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        double height = p / (2 * k + 2);
        double rsl = height * height * k;
        return rsl;
    }


    public static void main(String[] args) {
        double result1 = SqArea.square(6, 2);
        System.out.println("Square " + result1);
    }
}