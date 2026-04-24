package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {
    private static final double EPS = 1e-8;

    @Test
    public void average_twoPositiveNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.0, s.average(1.0, 3.0), 0.0);
    }

    @Test
    public void average_withNegativeNumber() {
        Sqrt s = new Sqrt(0);
        assertEquals(1.0, s.average(-1.0, 3.0), 0.0);
    }

    @Test
    public void good_returnsTrueForExactSquare() {
        Sqrt s = new Sqrt(0);
        assertTrue(s.good(3.0, 9.0));
    }

    @Test
    public void good_returnsFalseWhenNotAccurateEnough() {
        Sqrt s = new Sqrt(0);
        assertFalse(s.good(1.0, 2.0));
    }

    @Test
    public void improve_firstStepForFourFromGuessOne() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.5, s.improve(1.0, 4.0), 0.0);
    }

    @Test
    public void improve_keepsGuessWhenAlreadyPerfect() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.0, s.improve(2.0, 4.0), 0.0);
    }

    @Test
    public void iter_returnsGuessIfAlreadyGood() {
        Sqrt s = new Sqrt(0);
        assertEquals(1.0, s.iter(1.0, 1.0), 0.0);
    }

    @Test
    public void iter_convergesForTwo() {
        Sqrt s = new Sqrt(0);
        double r = s.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2.0), r, EPS);
        assertTrue(s.good(r, 2.0));
    }

    @Test
    public void calc_worksForTwo() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), s.calc(), EPS);
    }

    @Test
    public void calc_worksForZero() {
        Sqrt s = new Sqrt(0.0);
        double r = s.calc();
        assertTrue(s.good(r, 0.0));
    }

    @Test
    public void calc_worksForNine() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.calc(), EPS);
    }
}
