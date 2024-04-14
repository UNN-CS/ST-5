package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class SgrtTest {
    private static final double DELTA = 1e-6;

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.5, sqrt.average(2, 3), DELTA);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2, 4));
        assertFalse(sqrt.good(3, 4));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.improve(2, 4), DELTA);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(1, 4), DELTA);
    }

    @Test
    public void testCalc() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test(expected = StackOverflowError.class)
    public void testCalcWithNegative() {
        Sqrt sqrt = new Sqrt(-4);
        sqrt.calc();
    }

    @Test
    public void testCalcOne() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcPerfectSquare() {
        Sqrt sqrt = new Sqrt(16);
        assertEquals(4.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrt = new Sqrt(1e6);
        assertEquals(1000.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcSmallNumber() {
        Sqrt sqrt = new Sqrt(1e-6);
        assertEquals(0.001, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcVeryCloseToOne() {
        Sqrt sqrt = new Sqrt(1 + DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcSlightlyLessThanOne() {
        Sqrt sqrt = new Sqrt(1 - DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }
}
