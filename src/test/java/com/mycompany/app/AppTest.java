package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testConstructor() {
        Sqrt sqrt = new Sqrt(3.0);
        assertNotNull(sqrt);
        assertEquals(3.0, sqrt.arg, 0.001);
        assertEquals(0.00000001, sqrt.delta, 0.000000001);
    }

    @Test
    public void testConstructor2() {
        Sqrt sqrt = new Sqrt(9.0);
        assertNotNull(sqrt);
        assertEquals(9.0, sqrt.arg, 0.001);
        assertEquals(0.00000001, sqrt.delta, 0.000000001);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(3.5, sqrt.average(4.0, 3.0), 0.001);
        assertEquals(5.0, sqrt.average(4.0, 6.0), 0.001);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), 0.001);
        assertEquals(100.0, sqrt.average(50.0, 150.0), 0.001);
    }

    @Test
    public void testAverage2() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(112.0, sqrt.average(111.0, 113.0), 0.001);
        assertEquals(145.0, sqrt.average(140.0, 150.0), 0.001);
        assertEquals(50.0, sqrt.average(-15.0, 115.0), 0.001);
        assertEquals(77.0, sqrt.average(99.0, 55.0), 0.001);
    }

    @Test
    public void testGoodExact() {
        Sqrt sqrt = new Sqrt(0.0);
        assertTrue(sqrt.good(4.0, 16.0));
        assertTrue(sqrt.good(3.0, 9.0));
        assertTrue(sqrt.good(5.0, 25.0));
    }

    @Test
    public void testGoodExact2() {
        Sqrt sqrt = new Sqrt(0.0);
        assertTrue(sqrt.good(10.0, 100.0));
        assertTrue(sqrt.good(13.0, 169.0));
        assertTrue(sqrt.good(15.0, 225.0));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);

        assertEquals(2.0, sqrt.improve(2.0, 4.0), 0.001);
        assertEquals(2.1665, sqrt.improve(3.0, 4.0), 0.001);
        assertEquals(3.125, sqrt.improve(4.0, 9.0), 0.001);
    }

    @Test
    public void testImproveForSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(1.5, sqrt.improve(1.0, 2.0), 0.001);

        assertEquals(1.41667, sqrt.improve(1.5, 2.0), 0.001);

        assertEquals(1.41422, sqrt.improve(1.41667, 2.0), 0.001);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.iter(2.0, 4.0), 0.000001);

        Sqrt sqrt2 = new Sqrt(9.0);
        assertEquals(3.0, sqrt2.iter(3.0, 9.0), 0.000001);
    }

    @Test
    public void testImproveForLargeNumbers() {
        Sqrt sqrt = new Sqrt(10000.0);

        assertEquals(125.0, sqrt.improve(50.0, 10000.0), 0.001);

        assertEquals(102.5, sqrt.improve(125.0, 10000.0), 0.001);

        assertEquals(100.03, sqrt.improve(102.5, 10000.0), 0.001);
    }

    @Test
    public void testImproveForFractionalNumbers() {
        Sqrt sqrt = new Sqrt(0.25);

        assertEquals(0.5, sqrt.improve(0.5, 0.25), 0.001);

        assertEquals(0.625, sqrt.improve(1.0, 0.25), 0.001);

        assertEquals(0.5125, sqrt.improve(0.625, 0.25), 0.001);
    }

    @Test
    public void testCalcIntegersHavingRoot() {
        Sqrt sqrt49 = new Sqrt(49);
        assertEquals(7, sqrt49.calc(), sqrt49.delta);

        Sqrt sqrt36 = new Sqrt(36);
        assertEquals(6, sqrt36.calc(), sqrt36.delta);

        Sqrt sqrt81 = new Sqrt(81);
        assertEquals(9, sqrt81.calc(), sqrt49.delta);

        Sqrt sqrt100 = new Sqrt(100);
        assertEquals(10, sqrt100.calc(), sqrt100.delta);

        Sqrt sqrt121 = new Sqrt(121);
        assertEquals(11, sqrt121.calc(), sqrt121.delta);

        Sqrt sqrt144 = new Sqrt(144);
        assertEquals(12, sqrt144.calc(), sqrt144.delta);

        Sqrt sqrt196 = new Sqrt(196);
        assertEquals(14, sqrt196.calc(), sqrt196.delta);
    }

    @Test
    public void testCalcIntegersNotHavingRoot() {
        Sqrt sqrt2 = new Sqrt(2);
        assertEquals(1.414213562, sqrt2.calc(), 0.000001);

        Sqrt sqrt3 = new Sqrt(3);
        assertEquals(1.732050808, sqrt3.calc(), 0.000001);

        Sqrt sqrt5 = new Sqrt(5);
        assertEquals(2.236067977, sqrt5.calc(), 0.000001);

        Sqrt sqrt6 = new Sqrt(6);
        assertEquals(2.449489743, sqrt6.calc(), 0.000001);

        Sqrt sqrt7 = new Sqrt(7);
        assertEquals(2.645751311, sqrt7.calc(), 0.000001);

        Sqrt sqrt8 = new Sqrt(8);
        assertEquals(2.828427125, sqrt8.calc(), 0.000001);

        Sqrt sqrt10 = new Sqrt(10);
        assertEquals(3.16227766, sqrt10.calc(), 0.000001);
    }

    @Test
    public void testCalcFractions() {
        Sqrt sqrt6_25 = new Sqrt(6.25);
        assertEquals(2.5, sqrt6_25.calc(), 0.000001);

        Sqrt sqrt0_01 = new Sqrt(0.01);
        assertEquals(0.1, sqrt0_01.calc(), 0.000001);

        Sqrt sqrt0_04 = new Sqrt(0.04);
        assertEquals(0.2, sqrt0_04.calc(), 0.000001);
    }

    @Test
    public void testCalcNonIntegers() {
        Sqrt sqrt2 = new Sqrt(2.0);
        assertEquals(1.41421356, sqrt2.calc(), 0.000001);

        Sqrt sqrt3 = new Sqrt(3.0);
        assertEquals(1.7320508, sqrt3.calc(), 0.000001);

        Sqrt sqrt5 = new Sqrt(5.0);
        assertEquals(2.2360679, sqrt5.calc(), 0.000001);

        Sqrt sqrt0_25 = new Sqrt(0.25);
        assertEquals(0.5, sqrt0_25.calc(), 0.000001);
    }

    @Test
    public void testCalcPerfectSquares() {
        Sqrt sqrt1 = new Sqrt(1.0);
        assertEquals(1.0, sqrt1.calc(), 0.000001);

        Sqrt sqrt4 = new Sqrt(4.0);
        assertEquals(2.0, sqrt4.calc(), 0.000001);

        Sqrt sqrt9 = new Sqrt(9.0);
        assertEquals(3.0, sqrt9.calc(), 0.000001);

        Sqrt sqrt16 = new Sqrt(16.0);
        assertEquals(4.0, sqrt16.calc(), 0.000001);

        Sqrt sqrt25 = new Sqrt(25.0);
        assertEquals(5.0, sqrt25.calc(), 0.000001);
    }

    @Test
    public void testConvergence() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        double expected = Math.sqrt(2.0);
        assertEquals(expected, result, 0.000001);
        assertTrue(Math.abs(result * result - 2.0) < sqrt.delta);
    }
}
