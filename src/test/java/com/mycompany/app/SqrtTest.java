package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    private static final double DELTA = 1e-9;

    @Test
    void testAveragePositive() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.5, sqrt.average(2, 3), DELTA);
    }

    @Test
    void testAverageNegative() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(-2.5, sqrt.average(-2, -3), DELTA);
    }

    @Test
    void testGoodTrueWhenDifferenceLessThanDelta() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void testGoodFalseWhenDifferenceGreaterThanDelta() {
        Sqrt sqrt = new Sqrt(4);
        assertFalse(sqrt.good(1.9, 4.0));
    }

    @Test
    void testGoodEdgeCaseExactlyDelta() {
        Sqrt sqrt = new Sqrt(4);
        double deltaVal = 1e-8;
        assertFalse(sqrt.good(2.0001, 4.0));
    }

    @Test
    void testImproveForSquareOfTwo() {
        Sqrt sqrt = new Sqrt(2);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), DELTA);
    }

    @Test
    void testImproveAfterFirstIteration() {
        Sqrt sqrt = new Sqrt(2);
        assertEquals(1.4166666666666667, sqrt.improve(1.5, 2.0), DELTA);
    }

    @Test
    void testIterConvergesForFour() {
        Sqrt sqrt = new Sqrt(4);
        double result = sqrt.iter(1.0, 4.0);
        assertEquals(2.0, result, DELTA);
    }

    @Test
    void testIterConvergesForZero() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.iter(1.0, 0.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    void testCalcSquareRootOfZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 1e-12);
    }

    @Test
    void testCalcSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    void testCalcSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2);
        double expected = Math.sqrt(2);
        assertEquals(expected, sqrt.calc(), DELTA);
    }

    @Test
    void testCalcSquareRootOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), DELTA);
    }

    @Test
    void testCalcSquareRootOfLargeNumber() {
        Sqrt sqrt = new Sqrt(10000);
        assertEquals(100.0, sqrt.calc(), DELTA);
    }
}