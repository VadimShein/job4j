package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }
    public double area() {
        double rsl;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            rsl = -1;
        }
        return rsl;
    }
    private boolean exist(double a, double c, double b) {
        boolean result = (a + b > c) && (b + c > a) && (a + c > b);
        return result;
    }
/*
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(2, 3);
        Point c = new Point(4, 0);
        Triangle tri = new Triangle(a, b, c);
        System.out.println(tri.area());
    }*/
}
