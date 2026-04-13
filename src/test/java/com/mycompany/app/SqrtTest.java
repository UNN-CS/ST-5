package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    @Test
    void testAveragePositiveNumbers() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(3.0, sqrt.average(2, 4));
    }

    @Test
    void testAverageNegativeNumbers() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(-3.0, sqrt.average(-2, -4));
    }

    @Test
    void testAverageMixedNumbers() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(1.0, sqrt.average(-2, 4));
    }

    @Test
    void testGoodTrue() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void testGoodFalse() {
        Sqrt sqrt = new Sqrt(4);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(4);
        double result = sqrt.improve(1.0, 4.0);
        assertEquals(2.5, result, 1e-6);
    }

    @Test
    void testIterPerfectSquare() {
        Sqrt sqrt = new Sqrt(9);
        double result = sqrt.iter(1.0, 9.0);
        assertEquals(3.0, result, 1e-6);
    }

    @Test
    void testIterNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2);
        double result = sqrt.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    void testCalcPerfectSquare() {
        Sqrt sqrt = new Sqrt(16);
        double result = sqrt.calc();
        assertEquals(4.0, result, 1e-6);
    }

    @Test
    void testCalcNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(5);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(5), result, 1e-6);
    }

    @Test
    void testCalcZero() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.calc();
        assertEquals(0.0, result, 1e-4);
    }

    @Test
    void testGoodWithDeltaBoundary() {
        Sqrt sqrt = new Sqrt(4);
        double guess = 2.0 + 1e-9;
        assertTrue(sqrt.good(guess, 4.0));
    }

}
