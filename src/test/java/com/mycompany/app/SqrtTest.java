package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SqrtTest {

    private static final double EPS = 1e-6;

    @Test
    public void average_returnsArithmeticMean() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(3.0, s.average(2.0, 4.0), EPS);
    }

    @Test
    public void average_handlesNegativeNumbers() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(-0.5, s.average(-2.0, 1.0), EPS);
    }

    @Test
    public void good_isTrueWhenGuessSquaredCloseToX() {
        Sqrt s = new Sqrt(1.0);
        assertTrue(s.good(2.0, 4.0));
    }

    @Test
    public void good_isFalseWhenGuessIsFarFromRoot() {
        Sqrt s = new Sqrt(1.0);
        assertFalse(s.good(1.0, 100.0));
    }

    @Test
    public void improve_movesGuessTowardSquareRootOfX() {
        Sqrt s = new Sqrt(1.0);
        double next = s.improve(1.0, 9.0);
        assertEquals(5.0, next, EPS);
    }

    @Test
    public void iter_returnsGuessImmediatelyWhenGood() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(3.0, s.iter(3.0, 9.0), EPS);
    }

    @Test
    public void iter_convergesThroughRecursiveCalls() {
        Sqrt s = new Sqrt(1.0);
        double r = s.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2.0), r, 1e-7);
    }

    @Test
    public void calc_computesSquareRootOfTwo() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), s.calc(), 1e-7);
    }

    @Test
    public void calc_computesSquareRootOfPerfectSquare() {
        Sqrt s = new Sqrt(25.0);
        assertEquals(5.0, s.calc(), 1e-7);
    }

    @Test
    public void calc_usesConstructorArg() {
        Sqrt s = new Sqrt(16.0);
        assertEquals(4.0, s.calc(), 1e-7);
    }

    @Test
    public void good_boundaryNearDelta() {
        Sqrt s = new Sqrt(1.0);
        double x = 4.0;
        double guess = 2.0 - 1e-5;
        assertFalse(s.good(guess, x));
    }
}
