package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SqrtTest {
    
    @Test
    public void testSqrtOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, 0.00000001);
    }
    
    @Test
    public void testSqrtOf9() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, 0.00000001);
    }
    
    @Test
    public void testSqrtOf16() {
        Sqrt sqrt = new Sqrt(16.0);
        double result = sqrt.calc();
        assertEquals(4.0, result, 0.00000001);
    }
    
    @Test
    public void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertTrue(Math.abs(result) < 0.0001);  
    }
    
    @Test
    public void testSqrtOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, 0.00000001);
    }
    
    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.average(4.0, 9.0);
        assertEquals(6.5, result, 0.00000001);
    }
    
    @Test
    public void testGoodTrue() {
        Sqrt sqrt = new Sqrt(4.0);
        boolean result = sqrt.good(2.0, 4.0);
        assertTrue(result);
    }
    
    @Test
    public void testGoodFalse() {
        Sqrt sqrt = new Sqrt(4.0);
        boolean result = sqrt.good(3.0, 4.0);
        assertFalse(result);
    }
    
    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.improve(2.0, 4.0);
        assertEquals(2.0, result, 0.00000001);
    }
    
    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.iter(2.0, 4.0);
        assertEquals(2.0, result, 0.00000001);
    }
    
    @Test
    public void testSqrtOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 0.00000001);
    }
    
    @Test
    public void testSqrtOfQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, 0.00000001);
    }
}
