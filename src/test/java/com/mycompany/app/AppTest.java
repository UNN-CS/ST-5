package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private Sqrt sqrt;
    private static final double EPS = 0.0001;

    @BeforeEach
    void setUp() {
        sqrt = new Sqrt(16.0);
    }

    @Test
    @DisplayName("average with positive numbers")
    void testAverageWithPositiveNumbers() {
        assertEquals(6.5, sqrt.average(4.0, 9.0), EPS);
        assertEquals(10.0, sqrt.average(10.0, 10.0), EPS);
    }

    @Test
    @DisplayName("average with negative numbers")
    void testAverageWithNegativeNumbers() {
        assertEquals(-6.5, sqrt.average(-4.0, -9.0), EPS);
        assertEquals(-10.0, sqrt.average(-10.0, -10.0), EPS);
    }

    @Test
    @DisplayName("average with zero")
    void testAverageWithZero() {
        assertEquals(5.0, sqrt.average(0.0, 10.0), EPS);
        assertEquals(-5.0, sqrt.average(0.0, -10.0), EPS);
    }

    @Test
    @DisplayName("good with exact guess")
    void testGoodWithExactGuess() {
        assertTrue(sqrt.good(4.0, 16.0));
        assertTrue(sqrt.good(5.0, 25.0));
    }

    @Test
    @DisplayName("good with inexact guess")
    void testGoodWithInexactGuess() {
        assertFalse(sqrt.good(3.0, 16.0));
        assertFalse(sqrt.good(4.9, 25.0));
    }

    @Test
    @DisplayName("good with boundary delta")
    void testGoodWithBoundaryValue() {
        Sqrt s = new Sqrt(4.0);
        s.delta = 0.01;
        assertTrue(s.good(2.001, 4.0));
        assertFalse(s.good(2.1, 4.0));
        s.delta = 0.0001;
        assertTrue(s.good(2.00001, 4.0));
    }

    @Test
    @DisplayName("improve with exact guess")
    void testImproveWithExactGuess() {
        assertEquals(4.0, sqrt.improve(4.0, 16.0), EPS);
        assertEquals(5.0, sqrt.improve(5.0, 25.0), EPS);
    }

    @Test
    @DisplayName("improve with inexact guess")
    void testImproveWithInexactGuess() {
        double result = sqrt.improve(3.0, 16.0);
        assertTrue(result > 4.16 && result < 4.17);
    }

    @Test
    @DisplayName("iter with single iteration")
    void testIterWithSingleIteration() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.iter(2.0, 4.0), EPS);
    }

    @Test
    @DisplayName("calc for perfect square")
    void testCalcWithPerfectSquare() {
        assertEquals(5.0, new Sqrt(25.0).calc(), EPS);
        assertEquals(10.0, new Sqrt(100.0).calc(), EPS);
    }

    @Test
    @DisplayName("calc for non-perfect square")
    void testCalcWithNonPerfectSquare() {
        assertEquals(1.41421356, new Sqrt(2.0).calc(), EPS);
        assertEquals(1.7320508, new Sqrt(3.0).calc(), EPS);
    }

    @Test
    @DisplayName("calc for zero and one")
    void testCalcWithZeroAndOne() {
        assertEquals(0.0, new Sqrt(0.0).calc(), EPS);
        assertEquals(1.0, new Sqrt(1.0).calc(), EPS);
    }
}