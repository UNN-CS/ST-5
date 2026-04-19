package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static final double DELTA = 1e-7;

    @Test
    void constructorStoresArgumentAndCalcWorks() {
        Sqrt sqrt = new Sqrt(9.0);

        double result = sqrt.calc();

        assertEquals(3.0, result, DELTA);
    }

    @Test
    void averageReturnsMeanValueWithPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.average(2.0, 4.0);

        assertEquals(3.0, result, DELTA);
    }

    @Test
    void averageReturnsMeanValueWithNegativeNumbers() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.average(-2.0, -4.0);

        assertEquals(-3.0, result, DELTA);
    }

    @Test
    void averageReturnsMeanValueWithMixedNumbers() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.average(-2.0, 4.0);

        assertEquals(1.0, result, DELTA);
    }

    @Test
    void goodReturnsTrueForAccurateGuess() {
        Sqrt sqrt = new Sqrt(0);

        boolean result = sqrt.good(3.0, 9.0);

        assertTrue(result);
    }

    @Test
    void goodReturnsFalseForInaccurateGuess() {
        Sqrt sqrt = new Sqrt(0);

        boolean result = sqrt.good(2.0, 9.0);

        assertFalse(result);
    }

    @Test
    void improveReturnsBetterApproximation() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.improve(1.0, 9.0);

        assertEquals(5.0, result, DELTA);
    }

    @Test
    void iterReturnsSameGuessWhenItIsAlreadyGood() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.iter(3.0, 9.0);

        assertEquals(3.0, result, DELTA);
    }

    @Test
    void iterFindsSquareRootWhenGuessIsNotGood() {
        Sqrt sqrt = new Sqrt(0);

        double result = sqrt.iter(1.0, 9.0);

        assertEquals(3.0, result, 1e-4);
    }

    @Test
    void calcFindsSquareRootOfNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);

        double result = sqrt.calc();

        assertEquals(Math.sqrt(2.0), result, 1e-4);
    }

    @Test
    void calcFindsSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);

        double result = sqrt.calc();

        assertEquals(1.0, result, 1e-4);
    }
}