package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int count = 0;
        int countLeft = 0;
        int countRight = 0;

        while (count < rsl.length) {
            if (left[countLeft] <= right[countRight]) {
                rsl[count] = left[countLeft];
                if (countLeft < left.length) {
                    countLeft++;
                    count++;
                } else {
                    break;
                }
            } else {
                rsl[count] = right[countRight];
                if (countRight < right.length - 1) { // здесь без -1 выходит за размеры массива
                countRight++;
                    count++;
                } else {
                    break;
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
