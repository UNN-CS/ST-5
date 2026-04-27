package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    // 1. Тест метода average
    @Test
    void testAverage() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.5, sqrt.average(2, 3), 1e-9);
        assertEquals(0.0, sqrt.average(-1, 1), 1e-9);
    }

    // 2. Тест метода good
    @Test
    void testGood() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
        assertTrue(sqrt.good(2.000000001, 4.0));
        assertFalse(sqrt.good(1.9, 4.0));
    }

    // 3. Тест метода improve
    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(4);
        double improved = sqrt.improve(1.0, 4.0);
        assertEquals(2.5, improved, 1e-9);
        improved = sqrt.improve(improved, 4.0);
        assertEquals(2.05, improved, 1e-9);
    }

    // 4. Тест метода iter
    @Test
    void testIter() {
        Sqrt sqrt = new Sqrt(4);
        double result = sqrt.iter(1.0, 4.0);
        assertEquals(2.0, result, 1e-8);
    }

    // 5. calc для положительного числа
    @Test
    void testCalcPositive() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), 1e-8);
    }

    // 6. calc для нуля
    @Test
    void testCalcZero() {
        Sqrt sqrt = new Sqrt(0);
        assertTrue(sqrt.calc() < 1e-4, "Result should be very close to 0, but was " + sqrt.calc());
    }

    // 7. calc для маленького числа
    @Test
    void testCalcSmall() {
        Sqrt sqrt = new Sqrt(0.0001);
        assertEquals(0.01, sqrt.calc(), 1e-8);
    }

    // 8. calc для большого числа
    @Test
    void testCalcLarge() {
        Sqrt sqrt = new Sqrt(1e12);
        assertEquals(1_000_000.0, sqrt.calc(), 1e-3);
    }

    // 9. calc для отрицательного числа (должно бросить исключение)
    @Test
    void testCalcNegative() {
        Sqrt sqrt = new Sqrt(-4);
        assertThrows(IllegalArgumentException.class, sqrt::calc);
    }

    // 10. Сравнение с Math.sqrt для разных значений
    @Test
    void testAgainstMathSqrt() {
        double[] values = {0.5, 1, 2, 3, 10, 100, 0.001, 12345.67};
        for (double v : values) {
            Sqrt sqrt = new Sqrt(v);
            assertEquals(Math.sqrt(v), sqrt.calc(), 1e-8);
        }
    }
}