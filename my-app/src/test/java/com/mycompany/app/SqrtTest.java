package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SqrtTest {

    @Test
    public void testConstructor() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(4.0, sqrt.arg);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0));
        assertEquals(0.0, sqrt.average(-1.0, 1.0));
    }

    @Test
    public void testGoodTrue() {
        Sqrt sqrt = new Sqrt(1.0);
        assertTrue(sqrt.good(1.0, 1.0));
        assertTrue(sqrt.good(1.000000005, 1.0));
    }

    @Test
    public void testGoodFalse() {
        Sqrt sqrt = new Sqrt(1.0);
        assertFalse(sqrt.good(2.0, 1.0));
        assertFalse(sqrt.good(1.1, 1.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0));
        assertEquals(2.0, sqrt.improve(2.0, 4.0));
    }

    @Test
    public void testIterBaseCase() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.iter(1.0, 1.0));
    }

    @Test
    public void testIterRecursive() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.iter(1.0, 4.0);
        assertTrue(Math.abs(result - 2.0) < sqrt.delta);
    }

    @Test
    public void testCalc() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertTrue(Math.abs(result - 2.0) < sqrt.delta);
    }

    @Test
    public void testCalcNine() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertTrue(Math.abs(result - 3.0) < sqrt.delta);
    }

    @Test
    public void testCalcZero() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertTrue(sqrt.good(result, 0.0));
    }

    @Test
    public void testCalcOne() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result);
    }
}