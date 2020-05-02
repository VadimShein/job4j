package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;

        int leftLength = left.length();
        int rightLength = right.length();
        int size = leftLength;
        int dif = leftLength - rightLength;

        if (dif < 0) {
            size = rightLength;
        }
        for (int i = 0; i < size; i++) {
            if (i == leftLength) {
                rsl = right.charAt(i) - 2 * right.charAt(i);
                break;
            } else if (i == rightLength) {
                rsl = left.charAt(i);
                break;
            } else if (left.charAt(i) - right.charAt(i) != 0) {
                rsl = left.charAt(i) - right.charAt(i);
                break;
            }
        }
        return rsl;
    }
}