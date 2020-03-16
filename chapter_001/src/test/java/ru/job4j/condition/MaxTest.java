package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void maxThreeNumber() {
        int result = Max.max(1, 2, 5);
        assertThat(result, is(5));
    }

    @Test
    public void maxFourNumber() {
        int result = Max.max(5, 2, 5, 1);
        assertThat(result, is(5));
    }

}
