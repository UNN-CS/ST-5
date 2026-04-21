package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqrtTest {

    @Test
    void averageOfTwoPositiveValues() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-12);
    }

    @Test
    void averageWithNegativeAndPositiveValues() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(1.0, sqrt.average(-2.0, 4.0), 1e-12);
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
    void improveMakesGuessCloserToRoot() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 1e-12);
    }

    @Test
    void iterReturnsImmediateGuessWhenAlreadyGood() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(4.0, 16.0), 1e-9);
    }

    @Test
    void iterConvergesForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), 1e-6);
    }

    @Test
    void calcReturnsRootForPerfectSquare() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), 1e-6);
    }

    @Test
    void calcReturnsRootForFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1e-6);
    }

    @Test
    void calcReturnsRootForOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 1e-12);
    }

    @Test
    void calcMatchesMathSqrtForLargeValue() {
        Sqrt sqrt = new Sqrt(1_000_000.0);
        assertEquals(Math.sqrt(1_000_000.0), sqrt.calc(), 1e-4);
    }
}
