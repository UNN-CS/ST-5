package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    private double delta = 0.000001;

    @Test
    public void testCalcFour() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.calc(), delta);
    }

    @Test
    public void testCalcNine() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.calc(), delta);
    }

    @Test
    public void testCalcSixteen() {
        Sqrt s = new Sqrt(16.0);
        assertEquals(4.0, s.calc(), delta);
    }

    @Test
    public void testCalcOne() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(1.0, s.calc(), delta);
    }

    @Test
    public void testCalcFraction() {
        Sqrt s = new Sqrt(0.25);
        assertEquals(0.5, s.calc(), delta);
    }

    @Test
    public void testCalcSmallValue() {
        Sqrt s = new Sqrt(0.01);
        assertEquals(0.1, s.calc(), delta);
    }

    @Test
    public void testCalcLargeValue() {
        Sqrt s = new Sqrt(100.0);
        assertEquals(10.0, s.calc(), delta);
    }

    @Test
    public void testAverage() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.5, s.average(2.0, 3.0), delta);
    }

    @Test
    public void testIsGoodEnough() {
        Sqrt s = new Sqrt(2.0);
        assertTrue(s.good(1.41421356, 2.0));
    }

    @Test
    public void testIsNotGoodEnough() {
        Sqrt s = new Sqrt(2.0);
        assertFalse(s.good(1.0, 2.0));
    }

    @Test
    public void testImproveGuess() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(1.5, s.improve(1.0, 2.0), delta);
    }

    @Test
    public void testCalcCustomValue() {
        Sqrt s = new Sqrt(6.25);
        assertEquals(2.5, s.calc(), delta);
    }
}