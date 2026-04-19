package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAverage() {
        Sqrt s = new Sqrt(4);
        assertEquals(2.5, s.average(2, 3), 1e-9);
    }

    @Test
    public void testGoodTrue() {
        Sqrt s = new Sqrt(4);
        assertTrue(s.good(2.0, 4));
    }

    @Test
    public void testGoodFalse() {
        Sqrt s = new Sqrt(4);
        assertFalse(s.good(1.0, 4));
    }

    @Test
    public void testImprove() {
        Sqrt s = new Sqrt(4);
        double res = s.improve(2.0, 4);
        assertTrue(res > 1.0);
    }

    @Test
    public void testIter() {
        Sqrt s = new Sqrt(4);
        assertEquals(2.0, s.iter(1.0, 4), 1e-6);
    }

    @Test
    public void testCalc2() {
        Sqrt s = new Sqrt(2);
        assertEquals(Math.sqrt(2), s.calc(), 1e-6);
    }

    @Test
    public void testCalc4() {
        Sqrt s = new Sqrt(4);
        assertEquals(2.0, s.calc(), 1e-6);
    }

    @Test
    public void testCalc9() {
        Sqrt s = new Sqrt(9);
        assertEquals(3.0, s.calc(), 1e-6);
    }

    @Test
    public void testPrecision() {
        Sqrt s = new Sqrt(10);
        assertTrue(Math.abs(s.calc() - Math.sqrt(10)) < 1e-6);
    }

    @Test
    public void testConsistency() {
        Sqrt s = new Sqrt(16);
        assertEquals(s.calc(), s.calc(), 1e-9);
    }
}
