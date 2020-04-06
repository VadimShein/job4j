package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenArgLessZero() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    @Test
    public void whenArgNotNegative() {
        Fact fact = new Fact();
        int rsl = fact.calc(3);
        assertThat(rsl, is(6));

    }
}
