package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    private static final double DELTA = 1e-6;

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.average(2.0, 3.0), DELTA);
        assertEquals(5.0, sqrt.average(4.0, 6.0), DELTA);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), DELTA);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
        assertTrue(sqrt.good(2.000000001, 4.0));
        assertFalse(sqrt.good(2.1, 4.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(2.0, 4.0), DELTA);
        assertEquals(2.05, sqrt.improve(2.5, 4.0), DELTA);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.iter(2.0, 4.0), DELTA);
        assertEquals(2.0, sqrt.iter(10.0, 4.0), DELTA);
    }

    @Test
    public void testCalcPerfectSquare() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcSmallNumber() {
        Sqrt sqrt = new Sqrt(0.0001);
        assertEquals(0.01, sqrt.calc(), DELTA);
    }

    @Test
    public void testNegativeNumberThrowsException() {
        Sqrt sqrt = new Sqrt(-4.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sqrt.calc();
        });
        assertTrue(exception.getMessage().contains("Cannot compute sqrt of negative number"));
    }

    @Test
    public void testCalcPrecision() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(result * result, 2.0, 1e-8);
    }
}