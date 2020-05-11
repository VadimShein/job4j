package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.collection.Departments.sortAsc;
import static ru.job4j.collection.Departments.sortDesc;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        sortAsc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed2() {
        List<String> input = Arrays.asList("k1/sk1/ssk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        sortAsc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed3() {
        List<String> input = Arrays.asList("k1/sk1", "k2/sk2");
        List<String> expect = Arrays.asList("k2", "k2/sk2", "k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        sortDesc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        sortDesc(result);
        assertThat(result, is(expect));
    }
}