package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;

        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
                else result = forth;
            }
            else result = third;
        }
        else if (second > third) {
            if (second > forth) {
                result = second;
            }
            else result = forth;
        }
        else if (third > forth) {
            result = third;
        }


        return result;
    }

}