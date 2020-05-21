package ru.job4j.lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void admissionTo10A() {
        School sch = new School();
        List<Student> student = List.of(
                new Student("First", 70),
                new Student("Second", 50),
                new Student("Third", 30)
        );
        List<Student> result = sch.collect(student, x -> x.getScore() > 69);
        List<Student> expected = List.of(
                new Student("First", 70)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void admissionTo10B() {
        School sch = new School();
        List<Student> student = List.of(
                new Student("First", 70),
                new Student("Second", 50),
                new Student("Third", 30)
        );
        List<Student> result = sch.collect(student, x -> x.getScore() > 49 && x.getScore() < 70);
        List<Student> expected = List.of(
                new Student("Second", 50)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void admissionTo10C() {
        School sch = new School();
        List<Student> student = List.of(
                new Student("First", 70),
                new Student("Second", 50),
                new Student("Third", 30)
        );
        List<Student> result = sch.collect(student, x -> x.getScore() < 50);
        List<Student> expected = List.of(
                new Student("Third", 30)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void mapOfStudents() {
        School sch = new School();
        List<Student> student = List.of(
                new Student("First", 70),
                new Student("Second", 50),
                new Student("Third", 30)
        );
        Map<String, Student> result = sch.toMap(student);

        HashMap<String, Student> expected = new HashMap<>();
        expected.put("First",  new Student("First", 70));
        expected.put("Second",  new Student("Second", 50));
        expected.put("Third",  new Student("Third", 30));

        assertThat(result.entrySet(), is(expected.entrySet()));
    }

}
