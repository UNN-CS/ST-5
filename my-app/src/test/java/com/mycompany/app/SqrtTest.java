package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SqrtTest {
    
    private static final double DELTA = 1e-8;
    private Sqrt sqrt;
    
    @Before
    public void setUp() {
        sqrt = new Sqrt(4.0);
    }
    
    @Test
    public void testAverage() {
        assertEquals(2.5, sqrt.average(2.0, 3.0), DELTA);
        assertEquals(5.0, sqrt.average(4.0, 6.0), DELTA);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), DELTA);
    }
    
    @Test
    public void testGoodExact() {
        assertTrue(sqrt.good(2.0, 4.0));
        assertTrue(sqrt.good(3.0, 9.0));
    }
    
    @Test
    public void testGoodApproximate() {
        assertTrue(sqrt.good(2.000000001, 4.0));
        assertTrue(sqrt.good(1.999999999, 4.0));
    }
    
    @Test
    public void testGoodBad() {
        assertFalse(sqrt.good(2.1, 4.0));
        assertFalse(sqrt.good(1.9, 4.0));
    }
    
    @Test
    public void testImprove() {
        // Проверяем улучшение приближения для sqrt(4)
        double guess = 2.0;
        double improved = sqrt.improve(guess, 4.0);
        // Формула: (guess + x/guess)/2 = (2 + 4/2)/2 = (2 + 2)/2 = 2
        assertEquals(2.0, improved, DELTA);
        
        // Проверяем улучшение для sqrt(2) с начальным приближением 1
        Sqrt sqrt2 = new Sqrt(2.0);
        assertEquals(1.5, sqrt2.improve(1.0, 2.0), DELTA);
        
        // Проверяем улучшение для sqrt(9) с начальным приближением 3
        Sqrt sqrt9 = new Sqrt(9.0);
        assertEquals(3.0, sqrt9.improve(3.0, 9.0), DELTA);
    }
    
    @Test
    public void testIterOneStep() {
        Sqrt sqrt2 = new Sqrt(4.0);
        // Если guess уже хороший, iter возвращает его сразу
        double result = sqrt2.iter(2.0, 4.0);
        assertEquals(2.0, result, DELTA);
    }
    
    @Test
    public void testCalcSqrt4() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertEquals(2.0, sqrt4.calc(), DELTA);
    }
    
    @Test
    public void testCalcSqrt2() {
        Sqrt sqrt2 = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt2.calc(), DELTA);
    }
    
    @Test
    public void testCalcSqrt9() {
        Sqrt sqrt9 = new Sqrt(9.0);
        // Используем большую дельту, т.к. метод приближенный
        assertEquals(3.0, sqrt9.calc(), 1e-6);
    }
    
    @Test
    public void testCalcSqrt025() {
        Sqrt sqrt025 = new Sqrt(0.25);
        assertEquals(0.5, sqrt025.calc(), DELTA);
    }
    
    @Test
    public void testCalcSqrt1() {
        Sqrt sqrt1 = new Sqrt(1.0);
        assertEquals(1.0, sqrt1.calc(), DELTA);
    }
    
    @Test
    public void testCalcSqrt1000000() {
        Sqrt sqrtBig = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrtBig.calc(), DELTA);
    }
    
    @Test
    public void testConvergence() {
        Sqrt sqrt2 = new Sqrt(2.0);
        double guess = 1.0;
        double previousGuess;
        double trueValue = Math.sqrt(2.0);
        
        for (int i = 0; i < 5; i++) {
            previousGuess = guess;
            guess = sqrt2.improve(guess, 2.0);
            // Проверяем, что ошибка уменьшается
            double currentError = Math.abs(guess - trueValue);
            double previousError = Math.abs(previousGuess - trueValue);
            assertTrue("Ошибка должна уменьшаться на итерации " + i, 
                      currentError < previousError);
        }
    }
    
    @Test
    public void testDeltaPrecision() {
        Sqrt sqrt2 = new Sqrt(2.0);
        // Проверяем, что точность соответствует delta
        double result = sqrt2.calc();
        double error = Math.abs(result * result - 2.0);
        assertTrue("Ошибка должна быть меньше delta", error < sqrt2.delta);
    }
    
    @Test
    public void testDifferentArguments() {
        double[] testValues = {0.01, 0.1, 0.5, 1.5, 2.5, 10, 100, 10000};
        for (double val : testValues) {
            Sqrt sqrt = new Sqrt(val);
            double result = sqrt.calc();
            assertEquals("Корень из " + val, Math.sqrt(val), result, 1e-6);
        }
    }
}