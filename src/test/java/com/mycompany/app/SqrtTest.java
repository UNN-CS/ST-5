package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {
    private static final double EPS = 1.0e-9;

    @Test
    void averageReturnsMeanForPositiveValues() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageReturnsMeanForNegativeAndPositiveValues() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(1.0, sqrt.average(-2.0, 4.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(9.0);
        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    void goodReturnsFalseForPoorGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveReturnsBetterApproximation() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(5.0, sqrt.improve(1.0, 9.0), EPS);
    }

    @Test
    void improveUsesAverageFormula() {
        Sqrt sqrt = new Sqrt(2.0);
        double improved = sqrt.improve(2.0, 2.0);
        assertEquals(sqrt.average(2.0, 1.0), improved, EPS);
    }

    @Test
    void iterReturnsGuessImmediatelyWhenItIsGood() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(4.0, 16.0), EPS);
    }

    @Test
    void iterConvergesToSquareRootForNonPerfectInitialGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(1.0, 16.0), 1.0e-6);
    }

    @Test
    void calcReturnsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1.0e-6);
    }

    @Test
    void calcReturnsSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), 1.0e-6);
    }

    @Test
    void calcReturnsZeroForZeroArgument() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 1.0e-6);
    }

    @Test
    void calcReturnsSquareRootOfSmallFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1.0e-6);
    }
}
