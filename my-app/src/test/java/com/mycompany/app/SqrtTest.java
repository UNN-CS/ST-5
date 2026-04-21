package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса Sqrt")
class SqrtTest {

    private static final double DELTA = 0.00000001;

    @Test @DisplayName("calc: sqrt(4) = 2")
    void testCalcFour() {
        assertEquals(2.0, new Sqrt(4.0).calc(), DELTA);
    }

    @Test @DisplayName("calc: sqrt(2) примерно 1.4142")
    void testCalcTwo() {
        assertEquals(1.41421356, new Sqrt(2.0).calc(), 0.000001);
    }

    @Test @DisplayName("calc: sqrt(0) = 0")
    void testCalcZero() {
        assertEquals(0.0, new Sqrt(0.0).calc(), DELTA);
    }

    @Test @DisplayName("calc: sqrt(1) = 1")
    void testCalcOne() {
        assertEquals(1.0, new Sqrt(1.0).calc(), DELTA);
    }

    @Test @DisplayName("calc: отрицательное число, тогда исключение")
    void testCalcNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Sqrt(-4.0).calc());
    }

    @Test @DisplayName("calc: sqrt(10000) = 100")
    void testCalcLarge() {
        assertEquals(100.0, new Sqrt(10000.0).calc(), DELTA);
    }

    @Test @DisplayName("average: (4+6)/2 = 5")
    void testAverage() {
        assertEquals(5.0, new Sqrt(2.0).average(4.0, 6.0), DELTA);
    }

    @Test @DisplayName("average: отрицательные числа")
    void testAverageNegative() {
        assertEquals(-5.0, new Sqrt(2.0).average(-4.0, -6.0), DELTA);
    }

    @Test @DisplayName("good: точное приближение")
    void testGoodExact() {
        assertTrue(new Sqrt(4.0).good(2.0, 4.0));
    }

    @Test @DisplayName("good: неточное приближение")
    void testGoodInexact() {
        assertFalse(new Sqrt(4.0).good(1.0, 4.0));
    }

    @Test @DisplayName("improve: улучшение guess=1 для x=4")
    void testImprove() {
        assertEquals(2.5, new Sqrt(4.0).improve(1.0, 4.0), DELTA);
    }

    @Test @DisplayName("iter: рекурсия сходится для sqrt(9)")
    void testIter() {
        assertEquals(3.0, new Sqrt(9.0).iter(1.0, 9.0), 0.00001);
    }
}