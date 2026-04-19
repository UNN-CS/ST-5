package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

    private static final double EPS = 1e-7;

    @Test
    void average_ofTwoNumbers_returnsArithmeticMean() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.5, sqrt.average(2.0, 3.0), EPS);
    }

    @Test
    void average_withNegativeOperands_returnsMean() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(-0.5, sqrt.average(-2.0, 1.0), EPS);
    }

    @Test
    void good_whenGuessIsAccurate_returnsTrue() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void good_whenGuessIsInaccurate_returnsFalse() {
        Sqrt sqrt = new Sqrt(4);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void improve_refinesGuessTowardSquareRoot() {
        Sqrt sqrt = new Sqrt(2);
        double next = sqrt.improve(1.0, 2.0);
        assertEquals(1.5, next, EPS);
    }

    @Test
    void iter_whenGuessAlreadyGood_returnsSameGuess() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), EPS);
    }

    @Test
    void iter_whenGuessNeedsRefinement_converges() {
        Sqrt sqrt = new Sqrt(2);
        assertEquals(Math.sqrt(2.0), sqrt.iter(1.0, 2.0), EPS);
    }

    @Test
    void calc_forTwo_returnsSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
    }

    @Test
    void calc_forOne_returnsOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), EPS);
    }

    @Test
    void calc_forPerfectSquare_returnsExactRoot() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), EPS);
    }

    @Test
    void calc_forFraction_returnsExpectedRoot() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), EPS);
    }
}
