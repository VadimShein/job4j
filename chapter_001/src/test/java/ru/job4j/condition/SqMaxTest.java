package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void sqMax1() {
        int result = SqMax.max(7, 5, 6, 4);
        assertThat(result, is(7));
    }
    @Test
    public void sqMax2() {
        int result = SqMax.max(4, 7, 5, 6);
        assertThat(result, is(7));
    }
    @Test
    public void sqMax3() {
        int result = SqMax.max(6, 4, 7, 5);
        assertThat(result, is(7));
    }
    @Test
    public void sqMax4() {
        int result = SqMax.max(5,6, 4, 7);
        assertThat(result, is(7));
    }
}
