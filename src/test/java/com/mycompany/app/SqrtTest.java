package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void averageOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-12);
    }

    @Test
    void averageWithNegativeNumber() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.average(-2.0, 4.0), 1e-12);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveReturnsBetterGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(5.0, sqrt.improve(1.0, 9.0), 1e-12);
    }

    @Test
    void improvePreservesCorrectGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.improve(3.0, 9.0), 1e-12);
    }

    @Test
    void iterStopsImmediatelyForGoodGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(4.0, 16.0), 1e-12);
    }

    @Test
    void iterConvergesFromInitialGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(1.0, 16.0), 1e-7);
    }

    @Test
    void calcForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-7);
    }

    @Test
    void calcForPerfectSquare() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), 1e-7);
    }

    @Test
    void calcForFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1e-7);
    }
}
