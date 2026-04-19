package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqrtTest {
    private static final double EPSILON = 1.0E-7;

    @Test
    void constructorStoresArgument() {
        Sqrt sqrt = new Sqrt(25.0);

        assertEquals(25.0, sqrt.arg, EPSILON);
    }

    @Test
    void averageReturnsMeanForPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(5.0, sqrt.average(4.0, 6.0), EPSILON);
    }

    @Test
    void averageReturnsMeanForMixedSigns() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(1.0, sqrt.average(-2.0, 4.0), EPSILON);
    }

    @Test
    void goodReturnsTrueForExactRoot() {
        Sqrt sqrt = new Sqrt(0.0);

        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(0.0);

        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void improvePerformsOneNewtonIteration() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(1.5, sqrt.improve(1.0, 2.0), EPSILON);
    }

    @Test
    void improveMovesGuessCloserForPerfectSquare() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.25, sqrt.improve(2.0, 9.0), EPSILON);
    }

    @Test
    void iterReturnsGuessImmediatelyWhenItIsGood() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.0, sqrt.iter(3.0, 9.0), EPSILON);
    }

    @Test
    void iterFindsRootFromInitialGuess() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), EPSILON);
    }

    @Test
    void calcFindsRootForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPSILON);
    }

    @Test
    void calcFindsRootForPerfectSquare() {
        Sqrt sqrt = new Sqrt(16.0);

        assertEquals(4.0, sqrt.calc(), EPSILON);
    }
}
