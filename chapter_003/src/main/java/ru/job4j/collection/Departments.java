package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
//        List<String> rsl = new ArrayList<>();
        HashSet<String> tmp = new HashSet<>();

        for (String value : deps) {
            boolean index = false;
            String[] splitValue = value.split("/");
            String start = splitValue[0];
            for (String el : splitValue) {
                if (!index) {
                    tmp.add(start);
                    index = true;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}