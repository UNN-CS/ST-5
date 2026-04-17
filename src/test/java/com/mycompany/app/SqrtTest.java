package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqrtTest {
    private static final double EPS = 0.0001;

    @Test
    void averageReturnsMeanForPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);

        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageReturnsMeanForNegativeNumbers() {
        Sqrt sqrt = new Sqrt(0);

        assertEquals(-3.0, sqrt.average(-2.0, -4.0), EPS);
    }

    @Test
    void goodReturnsTrueWhenGuessIsCloseEnough() {
        Sqrt sqrt = new Sqrt(4);

        assertTrue(sqrt.good(2.000000001, 4.0));
    }

    @Test
    void goodReturnsFalseWhenGuessIsNotCloseEnough() {
        Sqrt sqrt = new Sqrt(4);

        assertFalse(sqrt.good(1.5, 4.0));
    }

    @Test
    void improveMakesGuessCloserForTwo() {
        Sqrt sqrt = new Sqrt(2);

        assertEquals(1.5, sqrt.improve(1.0, 2.0), EPS);
    }

    @Test
    void improveKeepsExactRootUnchanged() {
        Sqrt sqrt = new Sqrt(9);

        assertEquals(3.0, sqrt.improve(3.0, 9.0), EPS);
    }

    @Test
    void iterFindsSquareRootFromInitialGuess() {
        Sqrt sqrt = new Sqrt(16);

        assertEquals(4.0, sqrt.iter(1.0, 16.0), EPS);
    }

    @Test
    void calcFindsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(81);

        assertEquals(9.0, sqrt.calc(), EPS);
    }

    @Test
    void calcHandlesZero() {
        Sqrt sqrt = new Sqrt(0);

        assertEquals(0.0, sqrt.calc(), EPS);
    }

    @Test
    void calcRejectsNegativeNumbers() {
        Sqrt sqrt = new Sqrt(-1);

        assertThrows(IllegalArgumentException.class, sqrt::calc);
    }
}
