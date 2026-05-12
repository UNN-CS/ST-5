package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

    @Test
    void averageOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.average(1.0, 3.0), 1e-12);
    }

    @Test
    void averageOfNegativeAndPositive() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(0.0, sqrt.average(-2.0, 2.0), 1e-12);
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
    void improveReturnsExpectedNewtonStep() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), 1e-12);
    }

    @Test
    void improveKeepsPerfectGuessStable() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.improve(3.0, 9.0), 1e-12);
    }

    @Test
    void iterConvergesForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), 1e-7);
    }

    @Test
    void iterConvergesForLargeValue() {
        Sqrt sqrt = new Sqrt(10_000.0);
        assertEquals(100.0, sqrt.iter(1.0, 10_000.0), 1e-6);
    }

    @Test
    void calcReturnsSqrtForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-7);
    }

    @Test
    void calcReturnsSqrtForFractionalValue() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1e-7);
    }

    @Test
    void calcReturnsSqrtForOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 1e-12);
    }
}
