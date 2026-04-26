package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void testAveragePositiveNumbers() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.average(2.0, 3.0), 0.0001);
    }

    @Test
    void testAverageWithZero() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(1.5, sqrt.average(3.0, 0.0), 0.0001);
    }

    @Test
    void testAverageWithNegative() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(0.0, sqrt.average(-2.0, 2.0), 0.0001);
    }

    @Test
    void testGoodWhenCloseEnough() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.000000001, 4.0));
    }

    @Test
    void testGoodWhenNotCloseEnough() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(2.1, 4.0));
    }

    @Test
    void testGoodWithMarginExactlyDelta() {
        Sqrt sqrt = new Sqrt(4.0);
        sqrt.delta = 0.1;
        assertFalse(sqrt.good(2.05, 4.0));
    }

    @Test
    void testImproveFirstIteration() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 0.0001);
    }

    @Test
    void testImproveSecondIteration() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.05, sqrt.improve(2.5, 4.0), 0.0001);
    }

    @Test
    void testImproveWhenAlreadyAccurate() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 0.0001);
    }

    @Test
    void testImproveForLargeNumber() {
        Sqrt sqrt = new Sqrt(100.0);
        assertEquals(26.0, sqrt.improve(50.0, 100.0), 0.0001);
    }

    @Test
    void testCalcSquareRootOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.41421356, sqrt.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOf0() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertTrue(result < 0.0001, "Result should be very small, got " + result);
    }

    @Test
    void testCalcSquareRootOf9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOf1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), 0.0001);
    }

    @Test
    void testCalcSquareRootOf0point25() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 0.00000001);
    }
}