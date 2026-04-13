package com.mycompany.app; 
 
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test; 
 
public class AppTest { 
 
    @Test 
    public void testSqrtOfTwo() { 
        Sqrt sqrt = new Sqrt(2.0); 
        double result = sqrt.calc(); 
        assertEquals(Math.sqrt(2.0), result, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfFour() { 
        Sqrt sqrt = new Sqrt(4.0); 
        double result = sqrt.calc(); 
        assertEquals(2.0, result, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfSixteen() { 
        Sqrt sqrt = new Sqrt(16.0); 
        double result = sqrt.calc(); 
        assertEquals(4.0, result, 1e-6); 
    } 

    @Test 
    public void testSqrtOfTen() { 
        Sqrt sqrt = new Sqrt(10.0); 
        double result = sqrt.calc(); 
        assertEquals(Math.sqrt(10.0), result, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfOne() { 
        Sqrt sqrt = new Sqrt(1.0); 
        double result = sqrt.calc(); 
        assertEquals(1.0, result, 1e-6); 
    } 
 
    @Test 
    public void testAverage() { 
        Sqrt sqrt = new Sqrt(4.0); 
        double avg = sqrt.average(4.0, 9.0); 
        assertEquals(6.5, avg, 1e-6); 
    } 
 
    @Test 
    public void testGoodExact() { 
        Sqrt sqrt = new Sqrt(4.0); 
        assertTrue(sqrt.good(2.0, 4.0)); 
    } 
 
    @Test 
    public void testGoodBad() { 
        Sqrt sqrt = new Sqrt(4.0); 
        assertFalse(sqrt.good(3.0, 4.0)); 
    } 
 
    @Test 
    public void testImprove() { 
        Sqrt sqrt = new Sqrt(4.0); 
        double improved = sqrt.improve(3.0, 4.0); 
        assertEquals(2.1666666666666665, improved, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfNine() { 
        Sqrt sqrt = new Sqrt(9.0); 
        double result = sqrt.calc(); 
        assertEquals(3.0, result, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfLargeNumber() { 
        Sqrt sqrt = new Sqrt(1000000.0); 
        double result = sqrt.calc(); 
        assertEquals(1000.0, result, 1e-6); 
    } 
 
    @Test 
    public void testSqrtOfSmallNumber() { 
        Sqrt sqrt = new Sqrt(0.01); 
        double result = sqrt.calc(); 
        assertEquals(0.1, result, 1e-6); 
    } 
 
} 