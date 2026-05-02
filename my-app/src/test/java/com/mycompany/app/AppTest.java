package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testSqrt2() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 0.000001);
    }

    @Test
    public void testSqrt4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrt9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrt0_25() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrt1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrt100() {
        Sqrt sqrt = new Sqrt(100.0);
        assertEquals(10.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrt0_01() {
        Sqrt sqrt = new Sqrt(0.01);
        assertEquals(0.1, sqrt.calc(), 0.000001);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.5, sqrt.average(2, 3), 0.000001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(2);
        assertTrue(sqrt.good(Math.sqrt(2.0), 2.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(2);
        assertEquals(1.5, sqrt.improve(1.0, 2.0), 0.000001);
    }

    @Test
    public void testLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), 0.000001);
    }
}
