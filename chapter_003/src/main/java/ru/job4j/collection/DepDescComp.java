package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] o1Spl = o1.split("/");
        String[] o2Spl = o2.split("/");
        int size = Math.min(o1Spl.length, o2Spl.length);

        for (int index = 0; index < size; index++) {
            int pos = Math.min(o1Spl[index].length(), o2Spl[index].length());
            if (index == 0) {
                for (int i = 0; i < pos; i++) {
                    rsl = Character.compare(o2Spl[index].charAt(i), o1Spl[index].charAt(i));
                    if (rsl != 0) {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < pos; i++) {
                    rsl = Character.compare(o1Spl[index].charAt(i), o2Spl[index].charAt(i));
                    if (rsl != 0) {
                        break;
                    }
                }
            }
        }
        return rsl == 0 ? Integer.compare(o1.length(), o2.length()) : rsl;
    }
}