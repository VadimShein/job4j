package ru.job4j.condition;

public class DummyBot {

    public static String answer(String question) {
        String rsl;
        if (question.equals("Привет, Бот.")) {
            rsl = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            rsl = "До скорой встречи.";
        } else {
            rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        }
        return rsl;
    }

    public static void main(String[] args ) {
        String in = "Привет, Бот.";
        String result = DummyBot.answer(in);
        System.out.println(result);
    }
}

