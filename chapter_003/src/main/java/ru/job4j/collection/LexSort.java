package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        int size = rightLength;

        if (leftLength <= rightLength) {
            size = leftLength;
        }
        for (int i = 0; i < size; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
        }
        return rsl;
    }
}