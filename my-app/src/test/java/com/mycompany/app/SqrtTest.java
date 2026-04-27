package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SqrtTest {
    private static final double EPS = 1e-6;

    @Test
    void averageOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(2.0, sqrt.average(1.0, 3.0), EPS);
    }

    @Test
    void averageOfEqualNumbers() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(5.0, sqrt.average(5.0, 5.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void improveChangesGuessForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), EPS);
    }

    @Test
    void iterFindsSqrtOfFour() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.iter(1.0, 4.0), EPS);
    }

    @Test
    void calcFindsSqrtOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfNine() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfSixteen() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfSmallFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(10000.0);
        assertEquals(100.0, sqrt.calc(), EPS);
    }
}