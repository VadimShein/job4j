package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        int rsl = value / 70; // формула перевода рублей в евро
        return rsl;
    }

    public static int euroToRuble(int value) {
        int rsl = value * 70; // формула перевода евро в рубли
        return rsl;
    }

    public static int rubleToDollar(int value) {
        int rsl = value / 60; // формула перевода рублей в доллоры.
        return rsl;
    }

    public static int dollarToRuble(int value) {
        int rsl = value * 60; // формула перевода долларов в рубли
        return rsl;
    }

    public static float euroToDollar(int value) {
        float rsl = (float) (value * 70) / 60; // формула перевода евро в доллоры.
        return rsl;
    }

    public static float dollarToEuro(int value) {
        float rsl = (float) (value * 60) / 70; // формула перевода долларов в евро
        return rsl;
    }

    public static void main(String[] args) {
        int rub_euro = Converter.rubleToEuro(140);
        System.out.println("140 rubles are " + rub_euro + " euro.");

        int rub_dollar = Converter.rubleToDollar(180);
        System.out.println("180 rubles are " + rub_dollar + " dollar.");

        int euro_rub = Converter.euroToRuble(140);
        System.out.println("140 euro are " + euro_rub + " ruble.");

        int dollar_rub = Converter.dollarToRuble(140);
        System.out.println("140 dollars are " + dollar_rub + " ruble.");

        float dollar_euro = Converter.dollarToEuro(140);
        System.out.println("140 dollars are " + dollar_euro + " euro.");

        float euro_dollar = Converter.euroToDollar(140);
        System.out.println("140 euro are " + euro_dollar + " dollar.");

        //test
        int in = 140;
        int expected_rubEuro = 2;
        int expected_rubDollar = 2;
        int expected_euroRub = 9800;
        int expected_dollarRub = 8400;

        int out1 = rubleToEuro(in);
        int out2 = rubleToDollar(in);
        int out3 = euroToRuble(in);
        int out4 = dollarToRuble(in);

        boolean passed1 = expected_rubEuro == out1;
        boolean passed2 = expected_rubDollar == out2;
        boolean passed3 = expected_euroRub == out3;
        boolean passed4 = expected_dollarRub == out4;

        System.out.println("\n" + "Test...");
        System.out.println("140 rubles are 2 euro. Test result: " + passed1);
        System.out.println("140 rubles are 2 dollar. Test result: " + passed2);
        System.out.println("140 euro are 9800 rubles. Test result: " + passed3);
        System.out.println("140 dollar are 8400 rubles. Test result: " + passed4);

        System.out.println(expected_rubDollar == out2);

    }
}