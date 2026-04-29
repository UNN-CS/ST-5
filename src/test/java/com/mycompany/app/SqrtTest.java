package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

    private static final double EPS = 1e-9;

    @Test
    void constructorStoresArgument() {
        Sqrt sqrt = new Sqrt(2.5);

        assertEquals(2.5, sqrt.arg, EPS);
    }

    @Test
    void constructorStoresZero() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.arg, EPS);
    }

    @Test
    void averageWorksForPositiveNumbers() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageWorksForMixedSigns() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(-1.5, sqrt.average(-2.0, -1.0), EPS);
    }

    @Test
    void goodReturnsTrueWhenGuessIsCloseEnough() {
        Sqrt sqrt = new Sqrt(1.0);

        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsFalseWhenGuessIsFarAway() {
        Sqrt sqrt = new Sqrt(1.0);

        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void improveComputesNewtonStep() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(5.0, sqrt.improve(1.0, 9.0), EPS);
    }

    @Test
    void improveUsesAverageOfGuessAndQuotient() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(1.25, sqrt.improve(2.0, 1.0), EPS);
    }

    @Test
    void iterReturnsGuessWhenAlreadyGood() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(2.0, sqrt.iter(2.0, 4.0), EPS);
    }

    @Test
    void iterConvergesForPerfectSquare() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(3.0, sqrt.iter(1.0, 9.0), 1e-8);
    }

    @Test
    void calcComputesSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-8);
    }

    @Test
    void calcComputesSquareRootOfZero() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.calc(), 1e-4);
    }
}
