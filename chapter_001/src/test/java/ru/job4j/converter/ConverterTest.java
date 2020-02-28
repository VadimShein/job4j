package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);

    }
    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected1 = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected1, out);
    }

    @Test
    public void dollarToRuble() {
        int in = 140;
        int expected1 = 8400;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected1, out);
    }

    @Test
    public void euroToRuble() {
        int in = 140;
        int expected1 = 9800;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected1, out);
    }
}
