package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewtonRaphsonTest {
    private NewtonRaphson calculator;

    @Before
    public void init() {
        calculator = new NewtonRaphson(25.0);
    }

    @Test
    public void testArithmeticMeanBothPositive() {
        double result = calculator.arithmeticMean(10.0, 20.0);
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testArithmeticMeanWithNegatives() {
        double result = calculator.arithmeticMean(-5.0, 15.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testArithmeticMeanEqualNumbers() {
        double result = calculator.arithmeticMean(7.0, 7.0);
        assertEquals(7.0, result, 0.0001);
    }

    @Test
    public void testIsAccurateWhenEstimationCorrect() {
        assertTrue(calculator.isAccurate(5.0, 25.0));
    }

    @Test
    public void testIsAccurateWhenEstimationIncorrect() {
        assertFalse(calculator.isAccurate(3.0, 25.0));
    }

    @Test
    public void testIsAccurateBoundaryCase() {
        NewtonRaphson preciseCalc = new NewtonRaphson(4.0);
        preciseCalc.setPrecision(0.1);
        assertTrue(preciseCalc.isAccurate(2.05, 4.0));
    }

    @Test
    public void testRefineEstimate() {
        double improved = calculator.refineEstimate(3.0, 25.0);
        assertEquals(5.66666666, improved, 0.0001);
    }

    @Test
    public void testIteratePerfectSquare() {
        double result = calculator.iterate(1.0, 49.0);
        assertEquals(7.0, result, 0.0001);
    }

    @Test
    public void testIterateNonPerfectSquare() {
        double result = calculator.iterate(1.0, 10.0);
        assertEquals(Math.sqrt(10), result, 0.0001);
    }

    @Test
    public void testComputeSixteen() {
        NewtonRaphson sqrt16 = new NewtonRaphson(16.0);
        assertEquals(4.0, sqrt16.compute(), 0.0001);
    }

    @Test
    public void testComputeEightyOne() {
        NewtonRaphson sqrt81 = new NewtonRaphson(81.0);
        assertEquals(9.0, sqrt81.compute(), 0.0001);
    }

    @Test
    public void testComputeSqrtTwo() {
        NewtonRaphson sqrt2 = new NewtonRaphson(2.0);
        assertEquals(1.41421356, sqrt2.compute(), 0.0001);
    }

    @Test
    public void testComputeZero() {
        NewtonRaphson sqrt0 = new NewtonRaphson(0.0);
        assertEquals(0.0, sqrt0.compute(), 0.0001);
    }

    @Test
    public void testComputeOne() {
        NewtonRaphson sqrt1 = new NewtonRaphson(1.0);
        assertEquals(1.0, sqrt1.compute(), 0.0001);
    }

    @Test
    public void testComputeLargeNumber() {
        NewtonRaphson sqrtLarge = new NewtonRaphson(1000000.0);
        assertEquals(1000.0, sqrtLarge.compute(), 0.0001);
    }

    @Test
    public void testComputeFraction() {
        NewtonRaphson sqrtFraction = new NewtonRaphson(0.36);
        assertEquals(0.6, sqrtFraction.compute(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeNegativeThrowsException() {
        NewtonRaphson sqrtNegative = new NewtonRaphson(-9.0);
        sqrtNegative.compute();
    }

    @Test
    public void testSetAndGetPrecision() {
        calculator.setPrecision(0.0005);
        assertEquals(0.0005, calculator.getPrecision(), 0.0001);
    }

    @Test
    public void testDefaultPrecision() {
        NewtonRaphson defaultCalc = new NewtonRaphson(100.0);
        assertEquals(0.00000001, defaultCalc.getPrecision(), 0.0001);
    }

    @Test
    public void testGetTargetValue() {
        assertEquals(25.0, calculator.getTargetValue(), 0.0001);
    }

    @Test
    public void testComputeWithCustomPrecision() {
        NewtonRaphson customCalc = new NewtonRaphson(2.0);
        customCalc.setPrecision(0.01);
        assertEquals(1.4142, customCalc.compute(), 0.01);
    }

    @Test
    public void testRefineEstimateMultipleIterations() {
        double guess = 1.0;
        double target = 2.0;
        for (int i = 0; i < 3; i++) {
            guess = calculator.refineEstimate(guess, target);
        }
        assertEquals(1.41421568, guess, 0.0001);
    }

    @Test
    public void testIsAccurateWithCustomPrecision() {
        NewtonRaphson customCalc = new NewtonRaphson(4.0);
        customCalc.setPrecision(0.5);
        assertTrue(customCalc.isAccurate(2.4, 4.0));
    }
}