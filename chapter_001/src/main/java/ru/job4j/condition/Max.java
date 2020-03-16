package ru.job4j.condition;

public class Max {
    public static int max(int first, int second, int third) {
        int max = (first <= second) ? second : first;
        return  (third <= max) ? max : third;
    }
    public static int max(int first, int second, int third, int fourth) {
        int max = (first <= second) ? second : first;
        return  max(third, fourth, max);
    }
}
