package ru.job4j.calculator;

/**
 * Class Класс для вычисления суммы двух чисел
 * @author Shein Vadim (shein.v94@mail.ru)
 * @since 04.03.2020
 * @version 1
 */
public class Calculator {

    /**
     * Method plus
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void plus(int first, int second) {
        int result = first + second;
        System.out.println(result);
    }

    /**
     * Method main
     * @param args - args
     */
    public static void main(String[] args) {
        Calculator.plus(100, 500);
        Calculator.plus(4, 2);
        Calculator.plus(3, 5);


    }
}