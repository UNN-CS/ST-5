package com.st5;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {

    @Test
    public void TestAverageValue() {
        double DELTA = 1e-6;
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
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.improve(2, 4), DELTA);
    }

    @Test
    public void TestIterFunction() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(1, 4), DELTA);
    }

    @Test
    public void TestCalcFunction() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionBigNumber() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(1e6);
        assertEquals(1000.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionSmallNumber() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(1e-6);
        assertEquals(0.001, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionOnOne() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(1);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionNearRightOne() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(1 + DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionNearLeftOne() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(1 - DELTA);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFunctionSquare() {
        double DELTA = 1e-6;
        Sqrt sqrt = new Sqrt(16);
        assertEquals(4.0, sqrt.calc(), DELTA);
    }
}
