package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    
    private Sqrt sqrt;
    
    @BeforeEach
    void setUp() {
        sqrt = new Sqrt(4.0);
    }
    
    @Test
    void testAverage() {
        assertEquals(2.5, sqrt.average(2.0, 3.0), 0.0001);
        assertEquals(5.0, sqrt.average(4.0, 6.0), 0.0001);
        assertEquals(0.0, sqrt.average(-1.0, 1.0), 0.0001);
    }
    
    @Test
    void testGoodWithExactGuess() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertTrue(sqrt4.good(2.0, 4.0));
    }
    
    @Test
    void testGoodWithInexactGuess() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertFalse(sqrt4.good(1.9, 4.0));
    }
    
    @Test
    void testGoodWithBoundary() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertTrue(sqrt4.good(2.000000001, 4.0));
    }
    
    @Test
    void testImprove() {
        Sqrt sqrt4 = new Sqrt(4.0);
        double improved = sqrt4.improve(1.0, 4.0);
        assertEquals(2.5, improved, 0.0001);
        
        Sqrt sqrt9 = new Sqrt(9.0);
        improved = sqrt9.improve(2.0, 9.0);
        assertEquals(3.25, improved, 0.0001);
    }
    
    @Test
    void testIter() {
        Sqrt sqrt4 = new Sqrt(4.0);
        double result = sqrt4.iter(1.0, 4.0);
        assertEquals(2.0, result, 0.00000001);
    }
    
    @Test
    void testCalcFor4() {
        Sqrt sqrt4 = new Sqrt(4.0);
        assertEquals(2.0, sqrt4.calc(), 0.00000001);
    }
    
    @Test
    void testCalcFor9() {
        Sqrt sqrt9 = new Sqrt(9.0);
        assertEquals(3.0, sqrt9.calc(), 0.00000001);
    }
    
    @Test
    void testCalcFor2() {
        Sqrt sqrt2 = new Sqrt(2.0);
        double expected = Math.sqrt(2.0);
        assertEquals(expected, sqrt2.calc(), 0.00000001);
    }
    
    @Test
    void testCalcFor025() {
        Sqrt sqrt025 = new Sqrt(0.25);
        assertEquals(0.5, sqrt025.calc(), 0.00000001);
    }
    
    @Test
    void testCalcFor100() {
        Sqrt sqrt100 = new Sqrt(100.0);
        assertEquals(10.0, sqrt100.calc(), 0.00000001);
    }
    
    @Test
    void testCalcFor0() {
        Sqrt sqrt0 = new Sqrt(0.0);
        assertEquals(0.0, sqrt0.calc(), 0.00000001);
    }
    
    @Test
    void testDelta() {
        Sqrt sqrt2 = new Sqrt(2.0);
        double result = sqrt2.calc();
        double error = Math.abs(result * result - 2.0);
        assertTrue(error < sqrt2.delta);
    }
    
    @Test
    void testCalcForLargeNumber() {
        Sqrt sqrtLarge = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrtLarge.calc(), 0.0001);
    }
}