package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void maxTwoNumber() {
        Max maxTwo = new Max();
        int result = maxTwo.max(-5, -2);
        assertThat(result, is(-2));
    }

    @Test
    public void maxThreeNumber() {
        Max maxThree = new Max();
        int result = maxThree.max(1, 2, 5);
        assertThat(result, is(5));
    }

    @Test
    public void maxFourNumber() {
        Max maxFour = new Max();
        int result = maxFour.max(1, 2, 5, 8);
        assertThat(result, is(8));
    }
}
