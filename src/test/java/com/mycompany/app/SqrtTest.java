package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

    private static final double EPS = 1e-6;

    @Test
    void average_returnsArithmeticMean() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(3.0, s.average(2.0, 4.0), EPS);
        assertEquals(0.0, s.average(-2.0, 2.0), EPS);
    }

    @Test
    void good_isTrueWhenGuessSquaredCloseToX() {
        Sqrt s = new Sqrt(4.0);
        assertTrue(s.good(2.0, 4.0));
    }

    @Test
    void good_isFalseWhenGuessIsFarFromRoot() {
        Sqrt s = new Sqrt(4.0);
        assertFalse(s.good(1.0, 4.0));
    }

    @Test
    void improve_appliesNewtonStep() {
        Sqrt s = new Sqrt(9.0);
        double next = s.improve(3.0, 9.0);
        assertEquals(3.0, next, EPS);
        double fromTwo = s.improve(2.0, 9.0);
        assertEquals(3.25, fromTwo, EPS);
    }

    @Test
    void iter_returnsGuessWhenAlreadyGood() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.iter(2.0, 4.0), EPS);
    }

    @Test
    void iter_convergesFromRoughGuess() {
        Sqrt s = new Sqrt(9.0);
        double root = s.iter(1.0, 9.0);
        assertEquals(3.0, root, EPS);
    }

    @Test
    void calc_sqrtOfFour() {
        assertEquals(2.0, new Sqrt(4.0).calc(), EPS);
    }

    @Test
    void calc_sqrtOfNine() {
        assertEquals(3.0, new Sqrt(9.0).calc(), EPS);
    }

    @Test
    void calc_sqrtOfOne() {
        assertEquals(1.0, new Sqrt(1.0).calc(), EPS);
    }

    @Test
    void calc_sqrtOfTwo() {
        assertEquals(Math.sqrt(2.0), new Sqrt(2.0).calc(), EPS);
    }

    @Test
    void calc_sqrtOfFraction() {
        assertEquals(0.5, new Sqrt(0.25).calc(), EPS);
    }

    @Test
    void constructor_storesArgumentForCalc() {
        double arg = 16.0;
        Sqrt s = new Sqrt(arg);
        assertEquals(4.0, s.calc(), EPS);
    }
}
