package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SqrtTest {
    
    private Sqrt sqrt;
    
    @BeforeEach
    public void setUp() {
        sqrt = new Sqrt(4.0);
    }

    @Test
    public void testCalcFor4() {
        Sqrt s = new Sqrt(4.0);
        double result = s.calc();
        assertEquals(2.0, result, 0.00000001);
    }

    @Test
    public void testCalcFor9() {
        Sqrt s = new Sqrt(9.0);
        double result = s.calc();
        assertEquals(3.0, result, 0.00000001);
    }

    @Test
    public void testCalcFor16() {
        Sqrt s = new Sqrt(16.0);
        double result = s.calc();
        assertEquals(4.0, result, 0.00000001);
    }

    @Test
    public void testCalcForZero() {
        Sqrt s = new Sqrt(0.0);
        double result = s.calc();
        assertTrue(result < 0.0001, "Result should be very small, but was: " + result);
    }

    @Test
    public void testCalcFor2() {
        Sqrt s = new Sqrt(2.0);
        double result = s.calc();
        assertEquals(Math.sqrt(2.0), result, 0.00000001);
    }

    @Test
    public void testAverage() {
        double avg = sqrt.average(4.0, 9.0);
        assertEquals(6.5, avg, 0.00000001);
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
        double improved = sqrt.improve(2.0, 4.0);
        assertEquals(2.0, improved, 0.00000001);
    }

    @Test
    public void testIter() {
        double result = sqrt.iter(3.0, 9.0);
        assertEquals(3.0, result, 0.00000001);
    }
}