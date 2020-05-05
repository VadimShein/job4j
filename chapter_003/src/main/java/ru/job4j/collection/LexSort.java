package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftSpl = left.split("\\D+");
        String[] rightSpl = right.split("\\D+");

        int size = Math.min(leftSpl.length, rightSpl.length);
        for (int i = 0; i < size; i++) {
            rsl = Integer.compare(Integer.parseInt(leftSpl[i]), Integer.parseInt(rightSpl[i]));
        }
        return rsl;
    }
}