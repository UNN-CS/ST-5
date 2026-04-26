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
    public void testGoodTrue() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
        assertTrue(sqrt.good(2.000000001, 4.0));
    }

    @Test
    public void testGoodFalse() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.5, 4.0));
        assertFalse(sqrt.good(3.0, 4.0));
        assertFalse(sqrt.good(10.0, 4.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 0.0001);
        assertEquals(3.0, sqrt.improve(3.0, 9.0), 0.0001);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), 0.0001);
    }

    @Test
    public void testSqrt4() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, 0.00000001);
    }

    @Test
    public void testSqrt9() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, 0.00000001);
    }

    @Test
    public void testSqrt2() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 0.00000001);
    }

    @Test
    public void testSqrt025() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, 0.00000001);
    }

    @Test
    public void testSqrt1() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, 0.00000001);
    }

    @Test
    public void testSqrt1000000() {
        Sqrt sqrt = new Sqrt(1000000.0);
        double result = sqrt.calc();
        assertEquals(1000.0, result, 0.0001);
    }

    @Test
    public void testSqrt0001() {
        Sqrt sqrt = new Sqrt(0.0001);
        double result = sqrt.calc();
        assertEquals(0.01, result, 0.00000001);
    }

    @Test
    public void testAgainstMathSqrt() {
        double[] testValues = {0.5, 1.5, 3.7, 10.0, 100.0};
        for (double val : testValues) {
            Sqrt sqrt = new Sqrt(val);
            assertEquals(Math.sqrt(val), sqrt.calc(), 0.00000001);
        }
    }
}
