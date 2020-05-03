package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;

        int leftLength = left.length();
        int rightLength = right.length();
        int size = rightLength;
        int difference = leftLength - rightLength;

        if (leftLength <= rightLength) {
            size = leftLength;
        }
        for (int i = 0; i < size; i++) {
            rsl += left.charAt(i) - right.charAt(i);
        }
        if (rsl == 0) {
            rsl = difference;
        }
        return rsl;
    }
}