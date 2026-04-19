package com.induce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testCalcPositiveInteger() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 0.0001);
    }

    @Test
    void testCalcDouble() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 0.0001);
    }

    @Test
    void testSqrtOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.0001);
    }

    @Test
    void testLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), 0.0001);
    }

    @Test
    void testSmallNumber() {
        Sqrt sqrt = new Sqrt(0.0001);
        assertEquals(0.01, sqrt.calc(), 0.0001);
    }

    @Test
    void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.5, sqrt.average(2.0, 3.0));
    }

    @Test
    void testAverageNegative() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(-2.0, sqrt.average(-1.0, -3.0));
    }

    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(2.0);
        // (1 + 2/1) / 2 = 1.5
        assertEquals(1.5, sqrt.improve(1.0, 2.0));
    }

    @Test
    void testImproveAgain() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(1.4166666666666667, sqrt.improve(1.5, 2.0), 0.0001);
    }

    @Test
    void testGoodTrue() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.000000001, 4.0));
    }

    @Test
    void testGoodFalse() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(2.1, 4.0));
    }

    @Test
    void testIterTermination() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), 0.0001);
    }

    @Test
    void testInitialGuessImprovement() {
        Sqrt sqrt = new Sqrt(16.0);
        double firstGuess = 1.0;
        double nextGuess = sqrt.improve(firstGuess, 16.0);
        assertEquals(8.5, nextGuess);
    }
}
