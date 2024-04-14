package com.st5;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class SqrtClassTest {
    private static final double DELTA = 1e-6;

    @Test
    public void TestAverageValue() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.5, sqrt.average(2, 3), DELTA);
    }

    @Test
    public void TestGoodFunction() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2, 4));
        assertFalse(sqrt.good(3, 4));
    }

    @Test
    public void TestImproveFunction() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.improve(2, 4), DELTA);
    }

    @Test
    public void TestIterFunction() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(1, 4), DELTA);
    }

    @Test
    public void TestCalcFunction() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionBigNumber() {
        Sqrt sqrt = new Sqrt(1e6);
        assertEquals(1000.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionSmallNumber() {
        Sqrt sqrt = new Sqrt(1e-6);
        assertEquals(0.001, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionOnOne() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionNearRightOne() {
        Sqrt sqrt = new Sqrt(1 + DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionNearLeftOne() {
        Sqrt sqrt = new Sqrt(1 - DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionSquare() {
        Sqrt sqrt = new Sqrt(16);
        assertEquals(4.0, sqrt.calc(), DELTA);
    }
}
