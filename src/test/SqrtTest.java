package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {
    @Test
    public void testCalcForFour() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(6.5, sqrt.average(4.0, 9.0), 0.0001);
    }

    @Test
    public void testGoodReturnsTrue() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void testGoodReturnsFalse() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 0.0001);
    }

    @Test
    public void testIterDirect() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.iter(1.0, 4.0), 0.000001);
    }

    @Test
    public void testCalcForZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testCalcForLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testCalcForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.41421356, sqrt.calc(), 0.000001);
    }

    @Test
    public void testCalcForNegative() {
        Sqrt sqrt = new Sqrt(-4.0);
        assertNotNull(sqrt.calc());
    }
}