package ru.job4j.io;

import ru.job4j.array.Matrix;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        int[][] matrix = new Matrix().multiple(4);
            try (FileOutputStream out = new FileOutputStream("result.txt")) {
                for (int[] ints : matrix) {
                    String str = Arrays.toString(ints);
                    out.write((str + '\n').getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}