package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.5, sqrt.average(2.0, 3.0), 0.000001);
        assertEquals(0.0, sqrt.average(-2.0, 2.0), 0.000001);
        assertEquals(1.5, sqrt.average(1.0, 2.0), 0.000001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(9.0);
        assertTrue(sqrt.good(3.0, 9.0));
        assertFalse(sqrt.good(2.9, 9.0));
        assertFalse(sqrt.good(3.00001, 9.0));
        assertFalse(sqrt.good(2.99999999, 9.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(2.25, sqrt.improve(2.0, 5.0), 0.000001);
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 0.000001);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), 0.000001);
        double result = sqrt.iter(2.9, 9.0);
        assertTrue(Math.abs(result - 3.0) < 0.1);
    }

    @Test
    public void testCalcPerfectSquares() {
        assertEquals(2.0, new Sqrt(4.0).calc(), 0.000001);
        assertEquals(3.0, new Sqrt(9.0).calc(), 0.000001);
        assertEquals(4.0, new Sqrt(16.0).calc(), 0.000001);
    }

    @Test
    public void testCalcNonPerfectSquares() {
        assertEquals(1.414213562, new Sqrt(2.0).calc(), 0.000001);
        assertEquals(1.732050807, new Sqrt(3.0).calc(), 0.000001);
    }

    @Test
    public void testCalcZero() {
        assertTrue(Math.abs(new Sqrt(0.0).calc()) < 0.0001);
    }

    @Test
    public void testCalcSmallNumber() {
        assertEquals(0.316227766, new Sqrt(0.1).calc(), 0.000001);
    }

    @Test
    public void testCalcLargeNumber() {
        assertEquals(100.0, new Sqrt(10000.0).calc(), 0.000001);
    }

    @Test
    public void testCalcPrecision() {
        double result = new Sqrt(2.0).calc();
        assertTrue(Math.abs(result * result - 2.0) < 0.0000001);
    }
}