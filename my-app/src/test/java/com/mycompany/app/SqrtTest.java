package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class SqrtTest
{
    private Sqrt sqrt;
    private double tolerance = 1e-6;

    @Before
    public void setUp() {
        sqrt = new Sqrt(2.0);
    }

    // Тест 1: Вычисление квадратного корня из 2.0
    @Test
    public void testCalcSqrt2() {
        sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 1e-7);
    }

    // Тест 2: Вычисление квадратного корня из 4.0
    @Test
    public void testCalcSqrt4() {
        sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, 1e-7);
    }

    // Тест 3: Вычисление квадратного корня из 9.0
    @Test
    public void testCalcSqrt9() {
        sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, 1e-7);
    }

    // Тест 4: Вычисление квадратного корня из 1.0
    @Test
    public void testCalcSqrt1() {
        sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, 1e-7);
    }

    // Тест 5: Вычисление квадратного корня из 0.25
    @Test
    public void testCalcSqrt025() {
        sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, 1e-7);
    }

    // Тест 6: Метод average
    @Test
    public void testAverage() {
        sqrt = new Sqrt(2.0);
        double result = sqrt.average(4.0, 2.0);
        assertEquals(3.0, result, tolerance);
    }

    // Тест 7: Метод average с разными значениями
    @Test
    public void testAverageOtherValues() {
        sqrt = new Sqrt(10.0);
        double result = sqrt.average(10.0, 20.0);
        assertEquals(15.0, result, tolerance);
    }

    // Тест 8: Метод good - условие выполнено
    @Test
    public void testGoodTrue() {
        sqrt = new Sqrt(4.0);
        boolean result = sqrt.good(2.0, 4.0);
        assertTrue(result);
    }

    // Тест 9: Метод good - условие не выполнено
    @Test
    public void testGoodFalse() {
        sqrt = new Sqrt(2.0);
        boolean result = sqrt.good(1.0, 2.0);
        assertFalse(result);
    }

    // Тест 10: Метод improve
    @Test
    public void testImprove() {
        sqrt = new Sqrt(2.0);
        double result = sqrt.improve(1.0, 2.0);
        double expected = sqrt.average(1.0, 2.0 / 1.0);
        assertEquals(expected, result, tolerance);
    }

    // Тест 11: Вычисление квадратного корня из 16.0
    @Test
    public void testCalcSqrt16() {
        sqrt = new Sqrt(16.0);
        double result = sqrt.calc();
        assertEquals(4.0, result, 1e-7);
    }

    // Тест 12: Вычисление квадратного корня из 100.0
    @Test
    public void testCalcSqrt100() {
        sqrt = new Sqrt(100.0);
        double result = sqrt.calc();
        assertEquals(10.0, result, 1e-7);
    }
}
