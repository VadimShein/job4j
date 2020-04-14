package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int numb = 0;
        money -= price;
        while (money > 0) {
                if (money >= coins[numb]) {
                    money -= coins[numb];
                    rsl[size++] = coins[numb];
                } else {
                    numb++;
                }
        }
        return Arrays.copyOf(rsl, size);
    }
}



