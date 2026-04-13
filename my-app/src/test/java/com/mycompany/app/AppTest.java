package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void averageOfTwoNumbers() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-12);
    }

    @Test
    public void averageWithNegativeAndPositive() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(0.0, sqrt.average(-3.0, 3.0), 1e-12);
    }

    @Test
    public void goodReturnsTrueForPerfectSquareGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void goodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    public void improveChangesGuessCloserToRoot() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), 1e-12);
    }

    @Test
    public void iterReturnsSameGuessWhenAlreadyGood() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), 1e-12);
    }

    @Test
    public void iterFindsRootForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), 1e-7);
    }

    @Test
    public void calcFindsRootForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-7);
    }

    @Test
    public void calcFindsRootForPerfectSquare() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), 1e-7);
    }

    @Test
    public void calcForZeroIsNearZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 1e-4);
    }

    @Test
    public void calcForFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1e-7);
    }
}
