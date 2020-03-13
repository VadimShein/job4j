package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSort15() {
        int[] input = new int[] {5, 2, 3, 4, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort05() {
        int[] input = new int[] {4, 3, 1, 2, -1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-1, 1, 2, 3, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort13() {
        int[] input = new int[] {33, 1, 2};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 33};
        assertThat(result, is(expect));
    }
}