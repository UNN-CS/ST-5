package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final double eps = 1e-6;

    @Test
    public void testCalc1() {
        assertEquals(2.0, new Sqrt(4.0).calc(), eps);
    }

    @Test
    public void testCalc2() {
        assertEquals(3.0, new Sqrt(9.0).calc(), eps);
    }

    @Test
    public void testCalc3() {
        assertEquals(1.41421356, new Sqrt(2.0).calc(), eps);
    }

    @Test
    public void testCalc4() {
        assertEquals(1.0, new Sqrt(1.0).calc(), eps);
    }

    @Test
    public void testCalc5() {
        assertEquals(100.0, new Sqrt(10000.0).calc(), eps);
    }

    @Test
    public void testCalc6() {
        assertEquals(0.5, new Sqrt(0.25).calc(), eps);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(10.0, sqrt.average(5.0, 15.0), eps);
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), eps);
    }

    @Test
    public void testGoodTrue() {
        Sqrt sqrt = new Sqrt(2.0);
        assertTrue(sqrt.good(1.41421356, 2.0));
    }

    @Test
    public void testGoodFalse() {
        Sqrt sqrt = new Sqrt(2.0);
        assertFalse(sqrt.good(1.0, 2.0));
    }

    @Test
    public void testIterDirect() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(4.0, 16.0), eps);
    }

    @Test
    public void testAppMainExists() {
        App app = new App();
        assertNotNull(app);
    }
}