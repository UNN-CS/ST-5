package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SqrtTest {

    private static final double EPS = 1e-8;

    @Test
    void constructorStoresArgument() {
        Sqrt sqrt = new Sqrt(16.0);

        assertEquals(16.0, sqrt.arg, 0.0);
    }

    @Test
    void averageCalculatesMidpoint() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.0, sqrt.average(2.0, 4.0), EPS);
    }

    @Test
    void averageHandlesOppositeNumbers() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.average(-2.0, 2.0), EPS);
    }

    @ParameterizedTest(name = "good({0}, {1}) -> {2}")
    @CsvSource({
        "2.0, 4.0, true",
        "3.0, 9.0, true",
        "1.0, 4.0, false"
    })
    void goodProducesExpectedResult(double guess, double x, boolean expected) {
        Sqrt sqrt = new Sqrt(0.0);

        if (expected) {
            assertTrue(sqrt.good(guess, x));
        } else {
            assertFalse(sqrt.good(guess, x));
        }
    }

    @ParameterizedTest(name = "improve({0}, {1}) -> {2}")
    @CsvSource({
        "1.0, 4.0, 2.5",
        "2.0, 9.0, 3.25",
        "4.0, 16.0, 4.0"
    })
    void improveMovesGuessForward(double guess, double x, double expected) {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(expected, sqrt.improve(guess, x), EPS);
    }

    @Test
    void iterReturnsGuessWhenItIsAlreadyGood() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(2.0, sqrt.iter(2.0, 4.0), EPS);
    }

    @Test
    void iterConvergesForTwo() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), EPS);
    }

    @Test
    void iterConvergesForNine() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(3.0, sqrt.iter(1.0, 9.0), EPS);
    }

    @Test
    void iterConvergesForQuarter() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.5, sqrt.iter(1.0, 0.25), EPS);
    }

    @Test
    void calcReturnsSquareRootOfNine() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(3.0, sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsSquareRootOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);

        assertEquals(0.5, sqrt.calc(), EPS);
    }

    @Test
    void calcReturnsSquareRootOfHundred() {
        Sqrt sqrt = new Sqrt(100.0);

        assertEquals(10.0, sqrt.calc(), EPS);
    }
}
