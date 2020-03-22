package ru.job4j.tracker.inheritance;

public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
    public static void main(String[] args) {
        TextReport reportText = new TextReport();
        String text = reportText.generate("Report's name", "Report's body");
        System.out.println(text);

        JSONReport reportJSON = new JSONReport();
        String textJSON = reportJSON.generate("Report's name", "Report's body");
        System.out.println(textJSON);
    }
}