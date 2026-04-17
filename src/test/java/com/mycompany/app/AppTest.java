package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static final double DELTA = 1e-7;

    @Test
    public void testAveragePositiveNumbers() {
        Sqrt tmp = new Sqrt(0);
		assertEquals(3.0, tmp.average(2.0,4.0), DELTA);
    }
	
	@Test
	public void testAverageNegativeNumbers() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(-2.0, tmp.average(-1.0,-3.0), DELTA);
	}
	
	@Test
	public void testAverageMixedNumbers() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(1.0, tmp.average(-1.0,3.0), DELTA);
	}
	
	@Test
	public void testAverageCommutativity() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(tmp.average(3.0,-1.0), tmp.average(-1.0,3.0), DELTA);
	}
	
	@Test
    public void testGoodAccurateGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void testGoodInaccurateGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(3.0, 4.0));
    }
	
	@Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(9.0);
        // improve(2.0, 9.0) = average(2.0, 9.0/2.0) = average(2.0, 4.5) = 3.25
        assertEquals(3.25, sqrt.improve(2.0, 9.0), DELTA);
    }

    @Test
    public void testCalcPerfectSquare() {
        Sqrt sqrt = new Sqrt(4.0); // perfect square
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), DELTA);
    }
	
	@Test
    public void testCalcOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrt = new Sqrt(1e8);
        assertEquals(1e4, sqrt.calc(), DELTA);
    }
	
	@Test
    public void testCalcMaxDoubleValThrows() {
        Sqrt sqrt = new Sqrt(Double.MAX_VALUE);
		assertThrows(StackOverflowError.class, sqrt::calc);
    }

    @Test
    public void testCalcNegativeNumberThrows() {
        Sqrt sqrt = new Sqrt(-4.0);
        assertThrows(StackOverflowError.class, sqrt::calc);
    }
}
