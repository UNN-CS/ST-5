package com.mycompany.app;

public class NewtonRaphson {
    private double precision = 0.00000001;
    private double targetValue;

    public NewtonRaphson(double targetValue) {
        this.targetValue = targetValue;
    }

    public double arithmeticMean(double first, double second) {
        return (first + second) / 2.0;
    }

    public boolean isAccurate(double estimation, double original) {
        return Math.abs(estimation * estimation - original) < precision;
    }

    public double refineEstimate(double currentGuess, double original) {
        return arithmeticMean(currentGuess, original / currentGuess);
    }

    public double iterate(double currentGuess, double original) {
        if (isAccurate(currentGuess, original)) {
            return currentGuess;
        } else {
            return iterate(refineEstimate(currentGuess, original), original);
        }
    }

    public double compute() {
        if (targetValue < 0) {
            throw new IllegalArgumentException("Negative value not allowed: " + targetValue);
        }
        if (targetValue == 0) {
            return 0.0;
        }
        return iterate(1.0, targetValue);
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getPrecision() {
        return precision;
    }

    public double getTargetValue() {
        return targetValue;
    }
}