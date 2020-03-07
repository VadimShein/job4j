package ru.job4j.array;

public class BarleyBreak {
    public static void main(String[] args) {
        int[][] table = new int[3][3];
        int number = 1;
        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] =  number;
                number++;
            }
        }

    }
}
