package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String rsl = "Неизвестное слово: " + eng;
        return rsl;
    }
    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String say = word.engToRus("cat");
        System.out.println(say);
    }
}
