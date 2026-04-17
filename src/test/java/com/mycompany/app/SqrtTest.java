package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqrtTest {
    private static final double EPS = 0.0001;

    @Test
    void averageReturnsMiddleOfTwoPositiveNumbers() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageWorksWithNegativeAndPositiveNumbers() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(0.0, sqrt.average(-5.0, 5.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(4.0);

        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsTrueWhenGuessIsWithinDelta() {
        Sqrt sqrt = new Sqrt(9.0);

        assertTrue(sqrt.good(3.000000001, 9.0));
    }

    @Test
    void goodReturnsFalseWhenGuessIsOutsideDelta() {
        Sqrt sqrt = new Sqrt(9.0);

        assertFalse(sqrt.good(2.5, 9.0));
    }

    @Test
    void improveReturnsNewtonStep() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(5.0, sqrt.improve(1.0, 9.0), EPS);
    }

    @Test
    void iterFindsSquareRootFromInitialGuess() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(3.0, sqrt.iter(1.0, 9.0), EPS);
    }

    @Test
    void calcReturnsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(25.0);

        assertEquals(5.0, sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsSquareRootOfFraction() {
        Sqrt sqrt = new Sqrt(0.25);

        assertEquals(0.5, sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsApproximationForZero() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.calc(), EPS);
    }
}
