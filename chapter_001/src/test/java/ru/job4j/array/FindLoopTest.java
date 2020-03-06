package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenFind3() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindFalse() {
        int[] input = new int[] {4, 2, 10, 2, 4};
        int value = 4;
        int start = 1;
        int finish = 3;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind() {
        int[] input = new int[] {1, 2, 3, 1, 5};
        int value = 1;
        int start = 0;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 0;
        assertThat(result, is(expect));
    }
}