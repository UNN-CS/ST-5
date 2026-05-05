package com.mycompany.app;

/**
 * Calculates square roots with Newton's method (successive approximations).
 */
public class Sqrt {
    private static final double DEFAULT_DELTA = 0.00000001;

    double delta = DEFAULT_DELTA;
    double arg;

    public Sqrt(double arg) {
        if (Double.isNaN(arg) || arg < 0.0) {
            throw new IllegalArgumentException("Argument must be a non-negative number");
        }
        this.arg = arg;
    }

    public double average(double x, double y) {
        return (x + y) / 2.0;
    }

    public boolean good(double guess, double x) {
        return Math.abs(guess * guess - x) < delta;
    }

    public double improve(double guess, double x) {
        if (guess == 0.0) {
            return average(1.0, x);
        }
        return average(guess, x / guess);
    }

    public double iter(double guess, double x) {
        if (x == 0.0) {
            return 0.0;
        }
        if (good(guess, x)) {
            return guess;
        }
        return iter(improve(guess, x), x);
    }

    public double calc() {
        return iter(1.0, arg);
    }
}
