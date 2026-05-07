package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SqrtTest {
    private static final double EPS = 1e-6;

    @Test
    void averageOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(3.0);
        assertEquals(3.5, sqrt.average(2.0, 5.0), EPS);
    }

    @Test
    void averageOfEqualNumbers() {
        Sqrt sqrt = new Sqrt(3.0);
        assertEquals(7.0, sqrt.average(7.0, 7.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(9.0);
        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveChangesGuessForThree() {
        Sqrt sqrt = new Sqrt(3.0);
        assertEquals(2.0, sqrt.improve(2.0, 3.0), EPS);
    }

    @Test
    void iterFindsSqrtOfNine() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(1.0, 9.0), EPS);
    }

    @Test
    void calcFindsSqrtOfThree() {
        Sqrt sqrt = new Sqrt(3.0);
        assertEquals(Math.sqrt(3.0), sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.4142135623730951, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfTwentyFive() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfThirtySix() {
        Sqrt sqrt = new Sqrt(36.0);
        assertEquals(6.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfSmallFraction() {
        Sqrt sqrt = new Sqrt(0.64);
        assertEquals(0.8, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(14400.0);
        assertEquals(120.0, sqrt.calc(), EPS);
    }
}
