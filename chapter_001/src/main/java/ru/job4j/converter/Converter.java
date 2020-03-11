package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        int rsl = value / 70;
        return rsl;
    }

    public static int euroToRuble(int value) {
        int rsl = value * 70;
        return rsl;
    }

    public static int rubleToDollar(int value) {
        int rsl = value / 60;
        return rsl;
    }

    public static int dollarToRuble(int value) {
        int rsl = value * 60;
        return rsl;
    }

    public static float euroToDollar(int value) {
        float rsl = (float) (value * 70) / 60;
        return rsl;
    }

    public static float dollarToEuro(int value) {
        float rsl = (float) (value * 60) / 70;
        return rsl;
    }

    public static void main(String[] args) {
        int rubEuro = Converter.rubleToEuro(140);
        System.out.println("140 rubles are " + rubEuro + " euro.");
        int rubDollar = Converter.rubleToDollar(180);
        System.out.println("180 rubles are " + rubDollar + " dollar.");
        int euroRub = Converter.euroToRuble(140);
        System.out.println("140 euro are " + euroRub + " ruble.");
        int dollarRub = Converter.dollarToRuble(140);
        System.out.println("140 dollars are " + dollarRub + " ruble.");
        float dollarEuro = Converter.dollarToEuro(140);
        System.out.println("140 dollars are " + dollarEuro + " euro.");
        float euroDollar = Converter.euroToDollar(140);
        System.out.println("140 euro are " + euroDollar + " dollar.");
        int in = 140;
        int expectedRubEuro = 2;
        int expectedRubDollar = 2;
        int expectedEuroRub = 9800;
        int expectedDollarRub = 8400;
        int out1 = rubleToEuro(in);
        int out2 = rubleToDollar(in);
        int out3 = euroToRuble(in);
        int out4 = dollarToRuble(in);
        boolean passed1 = expectedRubEuro == out1;
        boolean passed2 = expectedRubDollar == out2;
        boolean passed3 = expectedEuroRub == out3;
        boolean passed4 = expectedDollarRub == out4;
        System.out.println("\n" + "Test...");
        System.out.println("140 rubles are 2 euro. Test result: " + passed1);
        System.out.println("140 rubles are 2 dollar. Test result: " + passed2);
        System.out.println("140 euro are 9800 rubles. Test result: " + passed3);
        System.out.println("140 dollar are 8400 rubles. Test result: " + passed4);
        System.out.println(expectedRubDollar == out2);
    }
}