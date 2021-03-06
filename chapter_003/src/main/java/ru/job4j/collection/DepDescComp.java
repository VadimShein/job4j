package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] o1Spl = o1.split("/");
        String[] o2Spl = o2.split("/");
        rsl = o2Spl[0].compareTo(o1Spl[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}