package ru.job4j.loop;

public class Board {
    public static void paint(int width, int height) {
        for (int i = 0; i < height; i++ ) {
            boolean flag = false;
            for(int j = 1; j <= width; j++) {
                if((i + j) % 2 == 1) {
                    System.out.print("x");
                }
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board.paint(3, 3);
        System.out.println();
        Board.paint(4, 4);
    }

}
