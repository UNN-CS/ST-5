package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest 
{
    private static final double EPS = 1e-9;
    
    //
    // calc
    //
    @Test
    void testCalcZero() {
        assertEquals(0.0, new Sqrt(0.0).calc(), 1e-4);
    }

    @Test
    void testCalcFour() {
        assertEquals(2.0, new Sqrt(4.0).calc(), EPS);
    }

    @Test
    void testCalcLargeNumber() {
        assertEquals(Math.sqrt(985469.0), new Sqrt(985469.0).calc(), 1e-6);
    }

    @Test
    void testCalcSmallNumber() {
        assertEquals(1e-4, new Sqrt(1e-8).calc(), 1e-4);
    }

    //
    // average
    //
    @Test
    void testAvgPositives() {
        Sqrt s = new Sqrt(0);
        assertEquals(5.0, s.average(2.0, 8.0), EPS);
    }

    @Test
    void testAvgMixed() {
        Sqrt s = new Sqrt(0);
        assertEquals(1.5, s.average(4.0, -1.0), EPS);
    }

    @Test
    void testAvgLargeNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(5.0e9, s.average(1e9, 9e9), EPS);
    }

    //
    // good
    //
    @Test
    void testGoodTrue() {
        Sqrt s = new Sqrt(0);
        assertTrue(s.good(2.000000001, 4.0));
    }

    @Test
    void testGoodFalse() {
        Sqrt s = new Sqrt(0);
        assertFalse(s.good(2.1, 4.0));
    }

    @Test
    void testGoodLargeNumber() {
        Sqrt s = new Sqrt(0);
        double exact = Math.sqrt(985469.0);
        assertTrue(s.good(exact, 985469.0));
    }

    //
    // improve
    //
    @Test
    void testImprovePerfect() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.5, s.improve(1.0, 4.0), EPS);
    }

    @Test
    void testImproveLargeNumber() {
        Sqrt s = new Sqrt(0);
        double expected = (10000.0 + 98546983.0 / 10000.0) / 2.0;
        assertEquals(expected, s.improve(10000.0, 98546983.0), EPS);
    }

    @Test
    void testImproveSmallNumber() {
        Sqrt s = new Sqrt(0);
        assertEquals(0.5, s.improve(1.0, 1e-12), EPS);
    }

    //
    // iter
    //
    @Test
    void testIterConverge() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.iter(10.0, 4.0), 1e-9);
    }

    @Test
    void testIterLargeNumber() {
        Sqrt s = new Sqrt(985469.0);
        assertEquals(Math.sqrt(985469.0), s.iter(10000.0, 985469.0), 1e-8);
    }
}
