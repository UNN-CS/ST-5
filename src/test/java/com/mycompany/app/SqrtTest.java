package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SqrtTest {

    private static final double DELTA = 0.00000001;

    @Test
    public void testCalcPerfectSquare() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcSmallNumber() {
        Sqrt sqrt = new Sqrt(0.000025);
        assertEquals(0.005, sqrt.calc(), 0.00001);
    }

    @Test
    public void testCalcOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }
    
    @Test
    public void testCalcZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(1.5, sqrt.average(1.0, 2.0), DELTA);
    }

    @Test
    public void testGoodGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void testBadGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInput() {
        Sqrt sqrt = new Sqrt(-4.0);
        sqrt.calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImproveWithZeroGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        sqrt.improve(0, 4.0);
    }

    @Test
    public void testInfinity() {
        Sqrt sqrt = new Sqrt(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, sqrt.calc(), 0.0);
    }

    @Test
    public void testNaN() {
        Sqrt sqrt = new Sqrt(Double.NaN);
        assertEquals(Double.NaN, sqrt.calc(), 0.0);
    }
}
