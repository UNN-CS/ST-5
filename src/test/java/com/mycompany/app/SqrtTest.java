package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqrtTest {

    private Sqrt sqrtTwo;

    @BeforeEach
    void setUp() {
        sqrtTwo = new Sqrt(2.0);
    }

    @Test
    void average_returnsArithmeticMean() {
        assertEquals(2.5, sqrtTwo.average(2.0, 3.0), 1e-12);
        assertEquals(0.0, sqrtTwo.average(-1.0, 1.0), 1e-12);
    }

    @Test
    void good_trueWhenGuessSquaredCloseToX() {
        assertTrue(sqrtTwo.good(Math.sqrt(2.0), 2.0));
    }

    @Test
    void good_falseWhenGuessFarFromRoot() {
        assertFalse(sqrtTwo.good(1.0, 2.0));
    }

    @Test
    void improve_movesGuessTowardSqrt() {
        double guess = 1.0;
        double x = 2.0;
        double next = sqrtTwo.improve(guess, x);
        assertTrue(Math.abs(next * next - x) < Math.abs(guess * guess - x));
    }

    @Test
    void iter_returnsWhenGoodEnough() {
        double root = sqrtTwo.iter(1.0, 2.0);
        assertTrue(Math.abs(root * root - 2.0) < sqrtTwo.delta);
    }

    @Test
    void calc_sqrtOfTwo() {
        double r = sqrtTwo.calc();
        assertEquals(Math.sqrt(2.0), r, 1e-6);
    }

    @Test
    void calc_perfectSquareNine() {
        assertEquals(3.0, new Sqrt(9.0).calc(), 1e-6);
    }

    @Test
    void calc_perfectSquareSixteen() {
        assertEquals(4.0, new Sqrt(16.0).calc(), 1e-6);
    }

    @Test
    void calc_one() {
        assertEquals(1.0, new Sqrt(1.0).calc(), 1e-6);
    }

    @Test
    void calc_fraction() {
        assertEquals(0.5, new Sqrt(0.25).calc(), 1e-6);
    }

    @Test
    void calc_largeNumber() {
        double x = 1_000_000.0;
        assertEquals(1000.0, new Sqrt(x).calc(), 1e-3);
    }

    @Test
    void constructor_storesArgument() {
        Sqrt s = new Sqrt(42.0);
        assertEquals(Math.sqrt(42.0), s.calc(), 1e-5);
    }
}
