package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] element : list) {
            int index = 0;
            for (int ind : element) {
                rsl.add(element[index]);
                index++;
            }
        }
        return rsl;
    }
}