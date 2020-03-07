package ru.job4j.condition;

public class MultiMax {
    public static int max(int first, int second, int third) {
        int max1 = (first <= second) ? second : first;
        int result = (max1 <= third) ? third : max1;
        return result;
    }
}
