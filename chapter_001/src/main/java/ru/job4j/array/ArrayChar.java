package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] world, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            if (world[i] != pref[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
