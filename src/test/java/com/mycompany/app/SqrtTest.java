package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {

    private Sqrt sqrt;

    @BeforeEach
    void setUp() {
        sqrt = new Sqrt(4.0);
    }

    @Test
    void testAverageWithPositiveNumbers() {
        assertEquals(3.0, sqrt.average(2.0, 4.0), 0.0001);
    }

    @Test
    void testAverageWithZero() {
        assertEquals(2.5, sqrt.average(5.0, 0.0), 0.0001);
    }

    @Test
    void testAverageWithNegativeNumbers() {
        assertEquals(-3.0, sqrt.average(-2.0, -4.0), 0.0001);
    }

    @Test
    void testGoodWhenAccurate() {
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void testGoodWhenNotAccurate() {
        assertFalse(sqrt.good(1.5, 4.0));
    }

    @Test
    void testImprove() {
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 0.0001);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 0.0001);
    }

    @Test
    void testCalcSquareRootOfFour() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertEquals(2.0, sqrt4.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfTwo() {
        Sqrt sqrt2 = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt2.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfNine() {
        Sqrt sqrt9 = new Sqrt(9.0);
        assertEquals(3.0, sqrt9.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfOne() {
        Sqrt sqrt1 = new Sqrt(1.0);
        assertEquals(1.0, sqrt1.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfHundred() {
        Sqrt sqrt100 = new Sqrt(100.0);
        assertEquals(10.0, sqrt100.calc(), 0.00000001);
    }

    @Test
    void testCalcSquareRootOfSmallNumber() {
        Sqrt sqrtSmall = new Sqrt(0.25);
        assertEquals(0.5, sqrtSmall.calc(), 0.00000001);
    }

    @Test
    void testIterConvergesCorrectly() {
        Sqrt sqrt2 = new Sqrt(2.0);
        double result = sqrt2.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2.0), result, 0.00000001);
    }
}