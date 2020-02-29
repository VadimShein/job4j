package ru.job4j.condition;

public class MultiMax {
    public static int max(int first, int second, int third) {
        int max_1 = (first <= second) ? second : first;
        int result = (max_1 <= third) ? third : max_1;
        return result;
    }
}
