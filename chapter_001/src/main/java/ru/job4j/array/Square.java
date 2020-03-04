package ru.job4j.array;


import static java.lang.Math.pow;

public class Square {

    public static int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index < bound; index++) {
            rst[index] = (int) pow(index, 2);

        }
        return rst;
    }

    public static void main(String[] args) {
        int[] array = Square.calculate(4);
             for (int index = 0; index < array.length; index++) {
               System.out.println(array[index]);
            }
    }
}

