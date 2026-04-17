package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SqrtTest {

    @Test
    void testAverage1() {
        Sqrt s = new Sqrt(4);
        assertEquals(3.0, s.average(2, 4));
    }

    @Test
    void testAverage2() {
        Sqrt s = new Sqrt(4);
        assertEquals(5.0, s.average(6, 4));
    }

    @Test
    void testAverageNegative() {
        Sqrt s = new Sqrt(4);
        assertEquals(0.0, s.average(-2, 2));
    }

    @Test
    void testGoodTrue() {
        Sqrt s = new Sqrt(4);
        assertTrue(s.good(2, 4));
    }

    @Test
    void testGoodFalse() {
        Sqrt s = new Sqrt(4);
        assertFalse(s.good(1, 4));
    }

    @Test
    void testGoodWithDelta() {
        Sqrt s = new Sqrt(4);
        assertTrue(s.good(2.000000001, 4));
    }

    @Test
    void testImprove() {
        Sqrt s = new Sqrt(4);
        double result = s.improve(1, 4);
        assertTrue(result > 1);
    }

    @Test
    void testIter() {
        Sqrt s = new Sqrt(4);
        double result = s.iter(1, 4);
        assertEquals(2.0, result, 1e-6);
    }

    @Test
    void testCalc2() {
        Sqrt s = new Sqrt(2);
        assertEquals(Math.sqrt(2), s.calc(), 1e-6);
    }

    @Test
    void testCalc4() {
        Sqrt s = new Sqrt(4);
        assertEquals(2.0, s.calc(), 1e-6);
    }

    @Test
    void testCalc9() {
        Sqrt s = new Sqrt(9);
        assertEquals(3.0, s.calc(), 1e-6);
    }

    @Test
    void testCalc16() {
        Sqrt s = new Sqrt(16);
        assertEquals(4.0, s.calc(), 1e-6);
    }

    @Test
    void testCalc25() {
        Sqrt s = new Sqrt(25);
        assertEquals(5.0, s.calc(), 1e-6);
    }

    @Test
    void testCalcSmallNumber() {
        Sqrt s = new Sqrt(0.25);
        assertEquals(0.5, s.calc(), 1e-6);
    }

    @Test
    void testCalcBigNumber() {
        Sqrt s = new Sqrt(25000000);
        assertEquals(5000, s.calc(), 1e-6);
    }
}
