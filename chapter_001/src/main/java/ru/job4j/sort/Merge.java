package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int countLeft = 0;
        int countRight = 0;
        if (left.length == 0) {
            rsl = right;
        } else if (right.length == 0) {
            rsl = left;
        } else {
            for (int count = 0; count < rsl.length; count++) {
                if (countLeft >= left.length) {
                    rsl[count] = right[countRight];
                    countRight++;
                } else if (countRight >= right.length) {
                    rsl[count] = left[countLeft];
                    countLeft++;
                } else if (left[countLeft] < right[countRight]) {
                    rsl[count] = left[countLeft];
                    countLeft++;
                } else {
                    rsl[count] = right[countRight];
                    countRight++;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
