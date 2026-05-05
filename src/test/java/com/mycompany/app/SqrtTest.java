package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {
    @Test
    void averageReturnsMiddleBetweenTwoNumbers() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(5.0, sqrt.average(4.0, 6.0), 0.000000001);
    }

    @Test
    void averageWorksWithNegativeNumbers() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(-1.5, sqrt.average(-5.0, 2.0), 0.000000001);
    }

    @Test
    void goodReturnsTrueForAccurateGuess() {
        Sqrt sqrt = new Sqrt(4.0);

        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodReturnsFalseForPoorGuess() {
        Sqrt sqrt = new Sqrt(9.0);

        assertFalse(sqrt.good(2.0, 9.0));
    }

    @Test
    void improveMovesGuessCloserToSquareRoot() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(5.0, sqrt.improve(1.0, 9.0), 0.000000001);
    }

    @Test
    void improveHandlesZeroGuess() {
        Sqrt sqrt = new Sqrt(9.0);

        assertEquals(5.0, sqrt.improve(0.0, 9.0), 0.000000001);
    }

    @Test
    void iterReturnsExactGuessWhenItIsGood() {
        Sqrt sqrt = new Sqrt(16.0);

        assertEquals(4.0, sqrt.iter(4.0, 16.0), 0.000000001);
    }

    @Test
    void iterFindsSquareRootFromInitialGuess() {
        Sqrt sqrt = new Sqrt(25.0);

        assertEquals(5.0, sqrt.iter(1.0, 25.0), 0.0001);
    }

    @Test
    void calcFindsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);

        assertEquals(Math.sqrt(2.0), sqrt.calc(), 0.0001);
    }

    @Test
    void calcFindsSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(81.0);

        assertEquals(9.0, sqrt.calc(), 0.0001);
    }

    @Test
    void calcReturnsZeroForZeroArgument() {
        Sqrt sqrt = new Sqrt(0.0);

        assertEquals(0.0, sqrt.calc(), 0.000000001);
    }

    @Test
    void constructorRejectsNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> new Sqrt(-1.0));
    }

    @Test
    void constructorRejectsNaNArgument() {
        assertThrows(IllegalArgumentException.class, () -> new Sqrt(Double.NaN));
    }
}
