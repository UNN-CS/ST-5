package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    private final double delta = 0.00000001;

    @Test
    public void testCalcPositive() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.calc(), delta);
    }

    @Test
    public void testCalcPrecision() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), s.calc(), delta);
    }

    @Test
    public void testAverage() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.5, s.average(2.0, 3.0), 0.0);
    }

    @Test
    public void testGoodMethodTrue() {
        Sqrt s = new Sqrt(2.0);
        assertTrue(s.good(1.41421356, 2.0));
    }

    @Test
    public void testGoodMethodFalse() {
        Sqrt s = new Sqrt(2.0);
        assertFalse(s.good(1.5, 2.0));
    }

    @Test
    public void testImprove() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(1.5, s.improve(1.0, 2.0), 0.0);
    }

    @Test
    public void testRootOfOne() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(1.0, s.calc(), delta);
    }

    @Test
    public void testLargeNumber() {
        Sqrt s = new Sqrt(1000000.0);
        assertEquals(1000.0, s.calc(), delta);
    }

    @Test
    public void testSmallNumber() {
        Sqrt s = new Sqrt(0.0001);
        assertEquals(0.01, s.calc(), delta);
    }

    @Test
    public void testRootOfNine() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.calc(), delta);
    }
}
