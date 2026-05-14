package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit tests for Sqrt class
 */
public class SqrtTest {
    
    private Sqrt sqrt2;
    private Sqrt sqrt4;
    private Sqrt sqrt1;
    private Sqrt sqrtSmall;
    
    @BeforeEach
    public void setUp() {
        sqrt2 = new Sqrt(2.0);
        sqrt4 = new Sqrt(4.0);
        sqrt1 = new Sqrt(1.0);
        sqrtSmall = new Sqrt(0.25);
    }
    
    /**
     * Test 1: Constructor - verify that object is created correctly
     */
    @Test
    public void testConstructor() {
        assertNotNull(sqrt2);
        assertEquals(2.0, sqrt2.arg);
    }
    
    /**
     * Test 2: average() method with positive numbers
     */
    @Test
    public void testAveragePositive() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.average(2.0, 8.0);
        assertEquals(5.0, result);
    }
    
    /**
     * Test 3: average() method with negative numbers
     */
    @Test
    public void testAverageNegative() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.average(-2.0, -8.0);
        assertEquals(-5.0, result);
    }
    
    /**
     * Test 4: average() method with mixed numbers
     */
    @Test
    public void testAverageMixed() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.average(0.0, 10.0);
        assertEquals(5.0, result);
    }
    
    /**
     * Test 5: good() method returns true when condition is met
     */
    @Test
    public void testGoodConditionMet() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }
    
    /**
     * Test 6: good() method returns false when condition is not met
     */
    @Test
    public void testGoodConditionNotMet() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }
    
    /**
     * Test 7: improve() method - improves the guess
     */
    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        double improved = sqrt.improve(1.0, 4.0);
        // improve(1, 4) = average(1, 4/1) = average(1, 4) = 2.5
        assertEquals(2.5, improved);
    }
    
    /**
     * Test 8: calc() for sqrt(4) should return 2.0
     */
    @Test
    public void testCalcForFour() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.calc();
        assertEquals(2.0, result, 0.0001);
    }
    
    /**
     * Test 9: calc() for sqrt(2) should return approximately 1.414...
     */
    @Test
    public void testCalcForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 0.00001);
    }
    
    /**
     * Test 10: calc() for sqrt(1) should return 1.0
     */
    @Test
    public void testCalcForOne() {
        Sqrt sqrt = new Sqrt(1.0);
        double result = sqrt.calc();
        assertEquals(1.0, result, 0.0001);
    }
    
    /**
     * Test 11: calc() for sqrt(0.25) should return 0.5
     */
    @Test
    public void testCalcForSmallNumber() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, 0.0001);
    }
    
    /**
     * Test 12: calc() for sqrt(9) should return 3.0
     */
    @Test
    public void testCalcForNine() {
        Sqrt sqrt = new Sqrt(9.0);
        double result = sqrt.calc();
        assertEquals(3.0, result, 0.0001);
    }
    
    /**
     * Test 13: Verify high precision for sqrt(2)
     */
    @Test
    public void testPrecisionForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        double expected = Math.sqrt(2.0);
        assertEquals(expected, result, 1e-8);
    }
    
    /**
     * Test 14: iter() method - recursive iteration
     */
    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(4.0);
        double result = sqrt.iter(1.0, 4.0);
        assertEquals(2.0, result, 0.0001);
    }
}
