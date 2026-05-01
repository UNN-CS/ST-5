package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    
    private static final double DELTA = 1e-6;

    @Test
    void testSqrtOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    void testSqrtOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-8);
    }

    @Test
    void testSqrtOf0() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 1e-4);
    }

    @Test
    void testSqrtOf1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    void testSqrtOf9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), DELTA);
    }

    @Test
    void testSqrtOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), DELTA);
    }

    @Test
    void testSqrtOf100() {
        Sqrt sqrt = new Sqrt(100.0);
        assertEquals(10.0, sqrt.calc(), DELTA);
    }

    @Test
    void testAverage() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), DELTA);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), DELTA);
    }

    @Test
    void testGoodExact() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(2.0);
        double improved = sqrt.improve(1.0, 2.0);
        assertEquals(1.5, improved, DELTA);
    }

    @Test
    void testSqrtLargeNumber() {
        Sqrt sqrt = new Sqrt(10000.0);
        assertEquals(100.0, sqrt.calc(), DELTA);
    }

    @Test
    void testSqrtSmallFraction() {
        Sqrt sqrt = new Sqrt(0.01);
        assertEquals(0.1, sqrt.calc(), 1e-6);
    }
}
