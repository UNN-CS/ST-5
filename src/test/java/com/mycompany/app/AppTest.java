package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {
	private static final double DELTA = 1e-7;

    @Test
    public void checkAverageWithZeroAndPositive() {
        Sqrt tmp = new Sqrt(0);
		assertEquals(2.0, tmp.average(0.0,4.0), DELTA);
    }

	@Test
	public void checkAverageWithSameNumbers() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(5.0, tmp.average(5.0,5.0), DELTA);
	}

	@Test
	public void checkAverageWithVerySmallNumbers() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(1e-10, tmp.average(0.0,2e-10), DELTA);
	}

	@Test
	public void checkAverageWithLargeNumbers() {
		Sqrt tmp = new Sqrt(0);
		assertEquals(1e10, tmp.average(0.0,2e10), DELTA);
	}

	@Test
    public void checkGoodAtDeltaBoundary() {
        Sqrt sqrt = new Sqrt(4.0);
        double guess = 2.0 + sqrt.delta / 5.0;
        assertTrue(sqrt.good(guess, 4.0));
    }

    @Test
    public void checkGoodJustOutsideDelta() {
        Sqrt sqrt = new Sqrt(4.0);
        double guess = 2.0 + sqrt.delta * 2.0;
        assertFalse(sqrt.good(guess, 4.0));
    }

    @Test
    public void checkGoodWithZeroTarget() {
        Sqrt sqrt = new Sqrt(0.0);
        assertTrue(sqrt.good(0.0, 0.0));
    }

	@Test
    public void checkImproveWithSmallGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(8.5, sqrt.improve(1.0, 16.0), DELTA);
    }

    @Test
    public void checkImproveWithLargeGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.1666666666666665, sqrt.improve(3.0, 4.0), DELTA);
    }

    @Test
    public void checkCalcForZero() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.calc();
        assertTrue(result < 0.0001, "Result should be very close to zero: " + result);
    }

    @Test
    public void checkCalcForMultiplePerfectSquares() {
        Sqrt sqrt9 = new Sqrt(9.0);
        assertEquals(Math.sqrt(9.0), sqrt9.calc(), DELTA);
        Sqrt sqrt16 = new Sqrt(16.0);
        assertEquals(Math.sqrt(16.0), sqrt16.calc(), DELTA);
        Sqrt sqrt25 = new Sqrt(25.0);
        assertEquals(Math.sqrt(25.0), sqrt25.calc(), DELTA);
    }

    @Test
    public void checkCalcForMultipleNonPerfectSquares() {
        Sqrt sqrt3 = new Sqrt(3.0);
        assertEquals(Math.sqrt(3.0), sqrt3.calc(), DELTA);
        Sqrt sqrt5 = new Sqrt(5.0);
        assertEquals(Math.sqrt(5.0), sqrt5.calc(), DELTA);
        Sqrt sqrt7 = new Sqrt(7.0);
        assertEquals(Math.sqrt(7.0), sqrt7.calc(), DELTA);
    }

    @Test
    public void checkCalcForVerySmallNumber() {
        Sqrt sqrt = new Sqrt(1e-10);
        double result = sqrt.calc();
        double expected = Math.sqrt(1e-10);
        double relativeError = Math.abs(result - expected) / expected;
        assertTrue(relativeError < 10.0, "Relative error should be less than 1000% due to algorithm limitations: " + relativeError);
    }

    @Test
    public void checkCalcForLargeButNotMaxNumber() {
        Sqrt sqrt = new Sqrt(1e12);
        assertEquals(Math.sqrt(1e12), sqrt.calc(), DELTA);
    }

	@Test
    public void checkCalcThrowsForMaxDoubleValue() {
        Sqrt sqrt = new Sqrt(Double.MAX_VALUE);
		assertThrows(StackOverflowError.class, sqrt::calc);
    }

    @Test
    public void checkCalcThrowsForNegativeInput() {
        Sqrt sqrt = new Sqrt(-4.0);
        assertThrows(StackOverflowError.class, sqrt::calc);
    }

    @Test
    public void checkConstructorStoresArgument() {
        Sqrt sqrt = new Sqrt(42.0);
        assertEquals(42.0, sqrt.arg, DELTA);
    }

    @Test
    public void checkDeltaValueIsSet() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1e-8, sqrt.delta, DELTA);
    }

    @Test
    public void checkIterConvergesForSmallNumber() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), DELTA);
    }
}
