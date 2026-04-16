package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private static final double EPS = 1e-6;

    @Test
    void constructorStoresArgument() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(9.0, sqrt.arg, EPS);
    }

    @Test
    void averageOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(5.0, sqrt.average(4.0, 6.0), EPS);
    }

    @Test
    void averageOfNegativeAndPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(1.0, sqrt.average(-2.0, 4.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(0);
        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(0);
        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveChangesGuessCorrectly() {
        Sqrt sqrt = new Sqrt(0);
        double improved = sqrt.improve(1.0, 9.0);
        assertEquals(5.0, improved, EPS);
    }

    @Test
    void iterReturnsSameGuessIfAlreadyGood() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.iter(3.0, 9.0);
        assertEquals(3.0, result, EPS);
    }

    @Test
    void iterFindsSquareRootOfNine() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.iter(1.0, 9.0);
        assertEquals(3.0, result, EPS);
    }

    @Test
    void calcFindsSquareRootOfNine() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), EPS);
    }
}