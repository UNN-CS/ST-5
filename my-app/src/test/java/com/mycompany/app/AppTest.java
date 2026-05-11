package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {
    private static final double EPS = 1e-7;

    @Test
    public void averageReturnsArithmeticMean() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(5.0, sqrt.average(4.0, 6.0), EPS);
    }

    @Test
    public void averageWorksForNegativeValues() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(-2.0, sqrt.average(-1.0, -3.0), EPS);
    }

    @Test
    public void goodReturnsTrueForExactSquareRoot() {
        Sqrt sqrt = new Sqrt(2.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void goodReturnsFalseForPoorGuess() {
        Sqrt sqrt = new Sqrt(2.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    public void improveUsesNewtonStep() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), EPS);
    }

    @Test
    public void iterReturnsInitialGuessIfAlreadyGood() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), EPS);
    }

    @Test
    public void iterConvergesForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), EPS);
    }

    @Test
    public void calcReturnsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    public void calcReturnsSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(49.0);
        assertEquals(7.0, sqrt.calc(), EPS);
    }

    @Test
    public void calcReturnsSquareRootOfSmallFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), EPS);
    }

    @Test
    public void calcReturnsSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), EPS);
    }
}
