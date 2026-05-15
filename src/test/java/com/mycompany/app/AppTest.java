package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AppTest
{
    private Sqrt sqrt;
    @Before
    public void setUp() {
        sqrt = new Sqrt(4.0);
    }
    @Test
    public void testConstructor() {
        Sqrt s = new Sqrt(9.0);
        assertNotNull(s);
    }
    @Test
    public void testAverage() {
        double result = sqrt.average(4.0, 9.0);
        assertEquals(6.5, result, 0.0001);
    }
    @Test
    public void testAverageSameNumbers() {
        double result = sqrt.average(5.0, 5.0);
        assertEquals(5.0, result, 0.0001);
    }
    @Test
    public void testGoodTrue() {
        boolean result = sqrt.good(2.0, 4.0);
        assertTrue(result);
    }
    @Test
    public void testGoodFalse() {
        boolean result = sqrt.good(3.0, 4.0);
        assertFalse(result);
    }
    @Test
    public void testImprove() {
        double result = sqrt.improve(2.0, 4.0);
        assertEquals(2.0, result, 0.0001);
    }
    @Test
    public void testImproveBadGuess() {
        Sqrt s = new Sqrt(4.0);
        double result = s.improve(3.0, 4.0);
        assertEquals(2.166666, result, 0.0001);
    }
    @Test
    public void testIter() {
        double result = sqrt.iter(2.0, 4.0);
        assertEquals(2.0, result, 0.0001);
    }
    @Test
    public void testCalcFor4() {
        Sqrt s = new Sqrt(4.0);
        double result = s.calc();
        assertEquals(2.0, result, 0.0001);
    }
    @Test
    public void testCalcFor2() {
        Sqrt s = new Sqrt(2.0);
        double result = s.calc();
        assertEquals(Math.sqrt(2.0), result, 0.00000001);
    }
    @Test
    public void testCalcFor0() {
        Sqrt s = new Sqrt(0.0);
        double result = s.calc();
        assertEquals(0.0, result, 0.0001);
    }
    @Test
    public void testCalcFor1() {
        Sqrt s = new Sqrt(1.0);
        double result = s.calc();
        assertEquals(1.0, result, 0.0001);
    }
    @Test
    public void testCalcFor9() {
        Sqrt s = new Sqrt(9.0);
        double result = s.calc();
        assertEquals(3.0, result, 0.0001);
    }
    @Test
    public void testCalcForLargeNumber() {
        Sqrt s = new Sqrt(100.0);
        double result = s.calc();
        assertEquals(10.0, result, 0.0001);
    }
    @Test
    public void testDeltaPrecision() {
        Sqrt s = new Sqrt(2.0);
        double result = s.calc();
        double expected = Math.sqrt(2.0);
        double difference = Math.abs(result - expected);
        assertTrue(difference < 0.00000001);
    }
}
