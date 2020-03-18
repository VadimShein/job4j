package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        return (first <= second) ? second : first;
    }

    public int max(int first, int second, int third) {
        return max(third, max(first, second));

    }
    public int max(int first, int second, int third, int fourth) {
        return max(max(first, second), max(third, fourth));
    }
}
