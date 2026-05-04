package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.average(2.0, 3.0), 0.0001);
        assertEquals(5.0, sqrt.average(4.0, 6.0), 0.0001);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), 0.0001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(4.0);

        assertTrue(sqrt.good(2.0, 4.0));

        assertFalse(sqrt.good(2.1, 4.0));

        assertTrue(sqrt.good(2.000000001, 4.0));

        assertTrue(sqrt.good(1.999999998, 4.0));

        Sqrt sqrtZero = new Sqrt(0.0);
        assertTrue(sqrtZero.good(0.0, 0.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 0.0001);

        assertEquals(2.05, sqrt.improve(2.0, 4.2), 0.0001);

        assertEquals(2.5, sqrt.improve(1.0, 4.0), 0.0001);
    }

    @Test
    public void testSqrtOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, 0.00000001);
    }

    @Test
    public void testSqrtOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(1.41421356, result, 0.00000001);
    }

    @Test
    public void testSqrtOf0() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertEquals(0.0, result, 0.00000001);
    }

    @Test
    public void testSqrtOf1() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, 0.00000001);
    }

    @Test
    public void testSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(10000.0);
        double result = sqrt.calc();
        assertEquals(100.0, result, 0.00000001);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.iter(1.0, 9.0);
        assertEquals(3.0, result, 0.00000001);

        Sqrt sqrt2 = new Sqrt(16.0);
        double result2 = sqrt2.iter(1.0, 16.0);
        assertEquals(4.0, result2, 0.00000001);
    }

    @Test
    public void testPrecision() {
        Sqrt sqrt = new Sqrt(5.0);
        double result = sqrt.calc();
        double expected = Math.sqrt(5.0);
        assertTrue(Math.abs(result - expected) < sqrt.delta);
    }

    @Test
    public void testSqrtOfSmallNumber() {
        Sqrt sqrt = new Sqrt(0.0001);
        double result = sqrt.calc();
        assertEquals(0.01, result, 0.00000001);
    }

    @Test
    public void testNoExceptions() {
        Sqrt sqrt = new Sqrt(123.456);
        assertDoesNotThrow(() -> sqrt.calc());
    }

    @Test
    public void testImproveMultiple() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(5.0, sqrt.improve(1.0, 9.0), 0.0001);
        assertEquals(3.4, sqrt.improve(5.0, 9.0), 0.0001);
    }
}