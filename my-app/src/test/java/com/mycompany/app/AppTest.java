package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private static final double DELTA = 1e-6;

    @Test
    @DisplayName("Корень из 4 должен быть 2")
    void testSqrtOfFour() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 9 должен быть 3")
    void testSqrtOfNine() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 0 должен быть 0")
    void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 1 должен быть 1")
    void testSqrtOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 2 должен быть примерно 1.41421356")
    void testSqrtOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        double expected = Math.sqrt(2.0);
        assertEquals(expected, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 0.25 должен быть 0.5")
    void testSqrtOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, DELTA);
    }

    @Test
    @DisplayName("Корень из 100 должен быть 10")
    void testSqrtOfHundred() {
        Sqrt sqrt = new Sqrt(100.0);
        double result = sqrt.calc();
        assertEquals(10.0, result, DELTA);
    }

    @Test
    @DisplayName("Корень из очень маленького числа (1e-10)")
    void testSqrtOfVerySmall() {
        Sqrt sqrt = new Sqrt(1e-10);
        double result = sqrt.calc();
        double expected = Math.sqrt(1e-10);
        assertEquals(expected, result, 1e-4);
    }

    @Test
    @DisplayName("Проверка нескольких значений подряд")
    void testMultipleValues() {
        double[] testValues = {2.0, 3.0, 5.0, 7.0, 10.0, 15.0, 20.0};

        for (double value : testValues) {
            Sqrt sqrt = new Sqrt(value);
            double result = sqrt.calc();
            double expected = Math.sqrt(value);

            assertEquals(expected, result, DELTA,
                    () -> "Ошибка для значения: " + value);
        }
    }

    @Test
    @DisplayName("Проверка метода average")
    void testAverage() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.average(4.0, 6.0);
        assertEquals(5.0, result, DELTA);
    }

    @Test
    @DisplayName("Проверка метода good (хорошее приближение)")
    void testGoodWhenClose() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    @DisplayName("Проверка метода good (плохое приближение)")
    void testGoodWhenFar() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(10.0, 4.0));
    }

    @Test
    @DisplayName("Проверка метода improve")
    void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        double improved = sqrt.improve(3.0, 4.0);
        assertEquals(2.1666666666666665, improved, DELTA);
    }
}