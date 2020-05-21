package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixTransform {
    public  List<Integer> matrixTr(List<List<Integer>> lists) {
     //   return lists.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        return lists.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
