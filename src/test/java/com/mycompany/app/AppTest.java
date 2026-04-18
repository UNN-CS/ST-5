package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private Sqrt sqrt;

    @BeforeEach
    void setUp() {
        sqrt = new Sqrt(16.0);
    }

    @Test
    @DisplayName("Test 1: average with positive numbers")
    void testAverageWithPositiveNumbers() {
        assertEquals(6.5, sqrt.average(4.0, 9.0), 0.0001);
        assertEquals(10.0, sqrt.average(10.0, 10.0), 0.0001);
    }

    @Test
    @DisplayName("Test 2: average with negative numbers")
    void testAverageWithNegativeNumbers() {
        assertEquals(-6.5, sqrt.average(-4.0, -9.0), 0.0001);
        assertEquals(-10.0, sqrt.average(-10.0, -10.0), 0.0001);
    }

    @Test
    @DisplayName("Test 3: average with zero")
    void testAverageWithZero() {
        assertEquals(5.0, sqrt.average(0.0, 10.0), 0.0001);
        assertEquals(-5.0, sqrt.average(0.0, -10.0), 0.0001);
    }

    @Test
    @DisplayName("Test 4: good with exact guess")
    void testGoodWithExactGuess() {
        assertTrue(sqrt.good(4.0, 16.0));
        assertTrue(sqrt.good(5.0, 25.0));
    }

    @Test
    @DisplayName("Test 5: good with inexact guess")
    void testGoodWithInexactGuess() {
        assertFalse(sqrt.good(3.0, 16.0));
        assertFalse(sqrt.good(4.9, 25.0));
    }

    @Test
    @DisplayName("Test 6: good with boundary delta values")
    void testGoodWithBoundaryValue() {
        Sqrt sqrtWithDelta = new Sqrt(4.0);
        sqrtWithDelta.delta = 0.01;
        assertTrue(sqrtWithDelta.good(2.001, 4.0));
        assertFalse(sqrtWithDelta.good(2.1, 4.0));
        sqrtWithDelta.delta = 0.0001;
        assertTrue(sqrtWithDelta.good(2.00001, 4.0));
    }

    @Test
    @DisplayName("Test 7: improve with exact guess")
    void testImproveWithExactGuess() {
        assertEquals(4.0, sqrt.improve(4.0, 16.0), 0.0001);
        assertEquals(5.0, sqrt.improve(5.0, 25.0), 0.0001);
    }

    @Test
    @DisplayName("Test 8: improve with inexact guess")
    void testImproveWithInexactGuess() {
        double result = sqrt.improve(3.0, 16.0);
        assertTrue(result > 4.16 && result < 4.17,
                "Expected result around 4.1667, but got " + result);
    }

    @Test
    @DisplayName("Test 9: iter with single iteration")
    void testIterWithSingleIteration() {
        Sqrt sqrtPerfect = new Sqrt(4.0);
        double result = sqrtPerfect.iter(2.0, 4.0);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test 10: calc for perfect square")
    void testCalcWithPerfectSquare() {
        Sqrt sqrt25 = new Sqrt(25.0);
        assertEquals(5.0, sqrt25.calc(), 0.0001);

        Sqrt sqrt100 = new Sqrt(100.0);
        assertEquals(10.0, sqrt100.calc(), 0.0001);
    }

    @Test
    @DisplayName("Test 11: calc for non-perfect square")
    void testCalcWithNonPerfectSquare() {
        Sqrt sqrt2 = new Sqrt(2.0);
        assertEquals(1.41421356, sqrt2.calc(), 0.0001);

        Sqrt sqrt3 = new Sqrt(3.0);
        assertEquals(1.7320508, sqrt3.calc(), 0.0001);
    }

    @Test
    @DisplayName("Test 12: calc for zero and one")
    void testCalcWithZeroAndOne() {
        Sqrt sqrt0 = new Sqrt(0.0);
        assertEquals(0.0, sqrt0.calc(), 0.0001);

        Sqrt sqrt1 = new Sqrt(1.0);
        assertEquals(1.0, sqrt1.calc(), 0.0001);
    }
}