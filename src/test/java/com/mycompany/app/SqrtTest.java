package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class SqrtTest
{
    private static final double EPSILON = 1e-4;

    // Test 1: Квадратный корень из 4
    @Test
    public void testSqrtOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), EPSILON);
    }

    // Test 2: Квадратный корень из 9
    @Test
    public void testSqrtOf9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), EPSILON);
    }

    // Test 3: Квадратный корень из 2
    @Test
    public void testSqrtOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPSILON);
    }

    // Test 4: Квадратный корень из 1
    @Test
    public void testSqrtOf1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), EPSILON);
    }

    // Test 5: Квадратный корень из очень маленького числа
    @Test
    public void testSqrtOfSmallNumber() {
        Sqrt sqrt = new Sqrt(0.01);
        assertEquals(0.1, sqrt.calc(), EPSILON);
    }

    // Test 6: Квадратный корень из большого числа
    @Test
    public void testSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(10000.0);
        assertEquals(100.0, sqrt.calc(), EPSILON);
    }

    // Test 7: Метод average
    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(5.0, sqrt.average(3.0, 7.0), EPSILON);
    }

    // Test 8: Метод average с одинаковыми значениями
    @Test
    public void testAverageEqualValues() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(4.0, sqrt.average(4.0, 4.0), EPSILON);
    }

    // Test 9: Метод good — должен вернуть true для точного значения
    @Test
    public void testGoodTrue() {
        Sqrt sqrt = new Sqrt(1.0);
        assertTrue(sqrt.good(3.0, 9.0));
    }

    // Test 10: Метод good — должен вернуть false для неточного значения
    @Test
    public void testGoodFalse() {
        Sqrt sqrt = new Sqrt(1.0);
        assertFalse(sqrt.good(2.0, 9.0));
    }

    // Test 11: Метод improve
    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(1.0);
        double improved = sqrt.improve(1.0, 4.0);
        assertEquals(2.5, improved, EPSILON);
    }

    // Test 12: Квадратный корень из 25
    @Test
    public void testSqrtOf25() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), EPSILON);
    }

    // Test 13: Квадратный корень из 0.25
    @Test
    public void testSqrtOf025() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), EPSILON);
    }

    // Test 14: Метод iter сходится к правильному значению
    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.iter(1.0, 16.0);
        assertEquals(4.0, result, EPSILON);
    }
}
