package ru.job4j.lambda;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class RangeFunctionTest {

    @Test
    public void whenLinearFunction() {
        RangeFunction function = new RangeFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticsFunction() {
        RangeFunction function = new RangeFunction();
        List<Double> result = function.diapason(5, 8, x -> x * x + x + 1);
        List<Double> expected = Arrays.asList(31D, 43D, 57D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        RangeFunction function = new RangeFunction();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }

}
