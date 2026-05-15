package com.mycompany.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SqrtTest {
    
    private static final double DELTA = 1e-6;
    
    @Test
    @DisplayName("Тест 1: Квадратный корень из 4")
    void testSqrtOfFour() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, DELTA);
    }
    
    @Test
    @DisplayName("Тест 2: Квадратный корень из 9")
    void testSqrtOfNine() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, DELTA);
    }
    
    @Test
    @DisplayName("Тест 3: Квадратный корень из 1")
    void testSqrtOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, DELTA);
    }
    
    @Test
    @DisplayName("Тест 4: Квадратный корень из 0.25")
    void testSqrtOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, DELTA);
    }
    
    @Test
    @DisplayName("Тест 5: Проверка метода average")
    void testAverageMethod() {
        Sqrt sqrt = new Sqrt(4.0);
        double avg = sqrt.average(4.0, 9.0);
        assertEquals(6.5, avg, DELTA);
        
        avg = sqrt.average(2.0, 8.0);
        assertEquals(5.0, avg, DELTA);
        
        avg = sqrt.average(10.0, 20.0);
        assertEquals(15.0, avg, DELTA);
    }
    
    @Test
    @DisplayName("Тест 6: Проверка метода good (исправленная версия)")
    void testGoodMethod() {
        Sqrt sqrt = new Sqrt(4.0);
        sqrt.delta = 0.1;
        assertTrue(sqrt.good(2.0, 4.0));
        assertFalse(sqrt.good(1.0, 4.0));
        
        // Проверка для другого числа
        Sqrt sqrt2 = new Sqrt(9.0);
        sqrt2.delta = 0.1;
        assertTrue(sqrt2.good(3.0, 9.0));
    }
    
    @Test
    @DisplayName("Тест 7: Проверка метода improve")
    void testImproveMethod() {
        Sqrt sqrt = new Sqrt(4.0);
        
        double improved = sqrt.improve(2.5, 4.0);
        assertEquals(2.05, improved, DELTA);
        
        improved = sqrt.improve(3.0, 9.0);
        assertEquals(3.0, improved, DELTA);
        
        improved = sqrt.improve(1.5, 2.0);
        assertEquals(1.4166666666666667, improved, DELTA);
    }
    
    @Test
    @DisplayName("Тест 8: Проверка метода iter")
    void testIterMethod() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.iter(2.0, 4.0);
        assertEquals(2.0, result, DELTA);
        
        Sqrt sqrt2 = new Sqrt(9.0);
        double result2 = sqrt2.iter(3.0, 9.0);
        assertEquals(3.0, result2, DELTA);
    }
    
    @ParameterizedTest
    @DisplayName("Тест 9: Квадратные корни целых чисел")
    @CsvSource({
        "4, 2",
        "16, 4",
        "25, 5",
        "36, 6",
        "49, 7",
        "64, 8",
        "81, 9",
        "100, 10"
    })
    void testSquareRootsOfPerfectSquares(double input, double expected) {
        Sqrt sqrt = new Sqrt(input);
        double result = sqrt.calc();
        assertEquals(expected, result, DELTA);
    }
    
    @ParameterizedTest
    @DisplayName("Тест 10: Квадратные корни иррациональных чисел")
    @CsvSource({
        "2, 1.414213562",
        "3, 1.732050808",
        "5, 2.236067977",
        "6, 2.449489743",
        "7, 2.645751311",
        "8, 2.828427125",
        "10, 3.16227766"
    })
    void testSquareRootsOfIrrationals(double input, double expected) {
        Sqrt sqrt = new Sqrt(input);
        double result = sqrt.calc();
        assertEquals(expected, result, 1e-6);
    }
    
    @Test
    @DisplayName("Тест 11: Проверка больших чисел")
    void testLargeNumbers() {
        Sqrt sqrt = new Sqrt(1000000.0);
        double result = sqrt.calc();
        assertEquals(1000.0, result, DELTA);
        
        Sqrt sqrt2 = new Sqrt(100000000.0);
        double result2 = sqrt2.calc();
        assertEquals(10000.0, result2, DELTA);
    }
    
    @Test
    @DisplayName("Тест 12: Проверка маленьких положительных чисел")
    void testSmallNumbers() {
        Sqrt sqrt = new Sqrt(0.000001);
        double result = sqrt.calc();
        assertEquals(0.001, result, 1e-4);
        
        Sqrt sqrt2 = new Sqrt(0.00000001);
        double result2 = sqrt2.calc();
        assertEquals(0.0001, result2, 5e-5);
    }
    
    @Test
    @DisplayName("Тест 13: Проверка повторяемости результатов")
    void testRepeatability() {
        Sqrt sqrt1 = new Sqrt(2.0);
        Sqrt sqrt2 = new Sqrt(2.0);
        
        double result1 = sqrt1.calc();
        double result2 = sqrt2.calc();
        
        assertEquals(result1, result2, DELTA);
    }
    
    @Test
    @DisplayName("Тест 14: Проверка, что результат в квадрате близок к исходному числу")
    void testSquareOfResult() {
        double[] testValues = {2.0, 3.0, 5.0, 7.0, 10.0, 15.0, 20.0, 50.0, 100.0};
        
        for (double value : testValues) {
            Sqrt sqrt = new Sqrt(value);
            double result = sqrt.calc();
            assertEquals(value, result * result, 1e-6);
        }
    }
}