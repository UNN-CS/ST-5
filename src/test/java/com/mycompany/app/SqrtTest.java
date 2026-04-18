package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {
    private static final double EPS = 1.0e-8;

    @Test
    void constructorStoresArgumentForCalculation() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(3.0, sqrt.calc(), EPS);
    }

    @Test
    void averageReturnsMeanForPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(5.0, sqrt.average(4.0, 6.0), EPS);
    }

    @Test
    void averageReturnsMeanForMixedSigns() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(1.0, sqrt.average(-2.0, 4.0), EPS);
    }

    @Test
    void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(0.0);

        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    void goodReturnsFalseForPoorGuess() {
        Sqrt sqrt = new Sqrt(0.0);

        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveReturnsNextNewtonApproximation() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(1.5, sqrt.improve(1.0, 2.0), EPS);
    }

    @Test
    void iterReturnsGuessImmediatelyWhenItIsGood() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(4.0, sqrt.iter(4.0, 16.0), EPS);
    }

    @Test
    void iterConvergesToSquareRootWhenGuessNeedsImprovement() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.0, sqrt.iter(1.0, 9.0), EPS);
    }

    @Test
    void calcFindsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfFraction() {
        Sqrt sqrt = new Sqrt(0.25);

        assertEquals(0.5, sqrt.calc(), EPS);
    }

    @Test
    void calcFindsSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);

        assertEquals(1.0, sqrt.calc(), EPS);
    }
}
