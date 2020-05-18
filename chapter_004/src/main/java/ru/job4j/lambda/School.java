package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> rsl = students.stream().filter(predictX -> predict.test(predictX)).collect(Collectors.toList());
            return new ArrayList<>(rsl);
    }
}
