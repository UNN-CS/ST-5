package com.mycompany.app;

public class Sqrt {
    private static final double DELTA = 0.00000001;
    double arg;

    public Sqrt(double arg) {
        this.arg = arg;
    }

    public double average(double x, double y) {
        return (x + y) * 0.5;
    }

    public boolean good(double guess, double x) {
        return Math.abs(guess * guess - x) < DELTA;
    }

    public double improve(double guess, double x) {
        return average(guess, x / guess);
    }

    public double iter(double guess, double x) {
        double current = guess;
        while (!good(current, x)) {
            current = improve(current, x);
        }
        return current;
    }

    public double calc() {
        return iter(1.0, arg);
    }
}
