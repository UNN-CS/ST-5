package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {
    private static final double EPS = 1.0e-9;

    @Test
    void constructorStoresArgument() {
        Sqrt sqrt = new Sqrt(25.0);

        assertEquals(25.0, sqrt.arg, EPS);
    }

    @Test
    void constructorKeepsDefaultDelta() {
        Sqrt sqrt = new Sqrt(4.0);

        assertEquals(0.00000001, sqrt.delta, EPS);
    }

    @Test
    void averageReturnsMidpointForPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageReturnsMidpointForMixedNumbers() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(1.0, sqrt.average(-2.0, 4.0), EPS);
    }

    @Test
    void averageReturnsZeroForZeros() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.average(0.0, 0.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactRoot() {
        Sqrt sqrt = new Sqrt(9.0);

        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    void goodReturnsTrueWhenGuessIsInsideDelta() {
        Sqrt sqrt = new Sqrt(1.0);

        assertTrue(sqrt.good(1.0 + 1.0e-10, 1.0));
    }

    @Test
    void goodReturnsFalseWhenGuessIsOutsideDelta() {
        Sqrt sqrt = new Sqrt(1.0);

        assertFalse(sqrt.good(1.0001, 1.0));
    }

    @Test
    void improveMatchesNewtonStepForNine() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(5.0, sqrt.improve(1.0, 9.0), EPS);
    }

    @Test
    void improveReducesLargeGuessForFour() {
        Sqrt sqrt = new Sqrt(4.0);

        assertEquals(2.5, sqrt.improve(4.0, 4.0), EPS);
    }

    @Test
    void improveUsesAverageOfGuessAndQuotient() {
        Sqrt sqrt = new Sqrt(2.0);
        double guess = 1.5;
        double x = 2.0;

        assertEquals(sqrt.average(guess, x / guess), sqrt.improve(guess, x), EPS);
    }

    @Test
    void iterReturnsGuessImmediatelyWhenItIsGood() {
        Sqrt sqrt = new Sqrt(16.0);

        assertEquals(4.0, sqrt.iter(4.0, 16.0), EPS);
    }

    @Test
    void iterFindsRootWhenInitialGuessIsTooSmall() {
        Sqrt sqrt = new Sqrt(4.0);

        assertEquals(2.0, sqrt.iter(0.5, 4.0), 1.0e-4);
    }

    @Test
    void iterFindsRootWhenInitialGuessIsTooLarge() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.iter(10.0, 2.0), 1.0e-4);
    }

    @Test
    void calcReturnsRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(1.0, sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1.0e-4);
    }

    @Test
    void calcReturnsRootOfFraction() {
        Sqrt sqrt = new Sqrt(0.25);

        assertEquals(0.5, sqrt.calc(), 1.0e-4);
    }

    @Test
    void calcReturnsRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(81.0);

        assertEquals(9.0, sqrt.calc(), 1.0e-4);
    }

    @Test
    void calcReturnsSmallValueForZeroArgument() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();

        assertTrue(result >= 0.0);
        assertTrue(result * result < sqrt.delta);
    }

    @Test
    void calcReturnsRootOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1_000_000.0);

        assertEquals(1000.0, sqrt.calc(), 1.0e-4);
    }
}
