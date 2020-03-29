package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        String text;
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            text = "Yes";
        } else if (answer == 1) {
            text = "No";
        } else {
            text = "Maybe";
        }
        System.out.println(text);
    }
}

