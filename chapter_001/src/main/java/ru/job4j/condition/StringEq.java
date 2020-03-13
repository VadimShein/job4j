package ru.job4j.condition;

public class StringEq {

    public static boolean check(String login) {
        String root = new String("root");
        boolean access;
        access = root.equals(login);
        return access;
    }

    public static void main(String[] args) {
        String your = "Vadim";
        boolean userHasAccess = StringEq.check(your);
        System.out.println(userHasAccess);
        your = "root";
        userHasAccess = StringEq.check(your);
        System.out.println(userHasAccess);
    }
}
