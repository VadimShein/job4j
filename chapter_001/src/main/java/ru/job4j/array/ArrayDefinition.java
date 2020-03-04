package ru.job4j.array;

public class ArrayDefinition {

    public static void main(String[] args) {
        short[] ages = new short[10];
        String[] surnames = new String[100500];
        float[] prices = new float[40];

        String[] names = new String[4];
        names[0] = "Vladimir";
        names[1] = "Alex";
        names[2] = "Sergey";
        names [3] = "Oleg";

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
