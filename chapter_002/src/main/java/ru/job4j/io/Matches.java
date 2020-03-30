package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int player = 0;
        int match = 11;
        while (match > 0) {
            if (match < 5 && match > 1) {
                System.out.println("Игрок " + (player + 1) + ", Вам даны " + match + " спички. Возьмите от 1 до 3");
            } else if (match == 1) {
                System.out.println("Игрок " + (player + 1) + ", Вам дана " + match + " спичка. Возьмите её");
            } else {
                System.out.println("Игрок " + (player + 1) + ", Вам даны " + match + " спичек. Возьмите от 1 до 3");
            }

            int select  = Integer.valueOf(input.nextLine());
                if (select > 0 && select < 4 && select <= match) {
                    match -= select;
                    System.out.println("Осталось " + match + " спичек");
                    player++;
                    if (player == 2) {
                        player = 0;
                    }
                } else {
                    System.out.println("Игрок " + (player + 1) + ", Осталось " + match + " спичек, введите еще раз число от 1 до " + match);
                }
        }
        if (player == 1) {
            System.out.println("Победил игрок 1");
        } else {
            System.out.println("Победил игрок 2");
        }
    }
}
