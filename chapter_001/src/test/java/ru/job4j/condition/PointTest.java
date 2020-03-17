package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 1, 1);
        double result = a.distance3d(b);
        double expected = 1.73;
        Assert.assertEquals(expected, result, 0.01);
    }
}
