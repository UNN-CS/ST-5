package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    private static final double EPS = 1e-7;

    @Test
    void average_ofTwoAndFour_returnsThree() {
        Sqrt s = new Sqrt(1);
        assertEquals(3.0, s.average(2.0, 4.0), EPS);
    }

    @Test
    void average_ofZeroAndZero_returnsZero() {
        Sqrt s = new Sqrt(1);
        assertEquals(0.0, s.average(0.0, 0.0), EPS);
    }

    @Test
    void average_ofNegativeAndPositive_returnsMidpoint() {
        Sqrt s = new Sqrt(1);
        assertEquals(0.0, s.average(-5.0, 5.0), EPS);
    }

    @Test
    void good_whenGuessSquaredCloseToX_returnsTrue() {
        Sqrt s = new Sqrt(1);
        assertTrue(s.good(2.0, 4.0));
    }

    @Test
    void good_whenGuessFarFromSqrt_returnsFalse() {
        Sqrt s = new Sqrt(1);
        assertFalse(s.good(10.0, 4.0));
    }

    @Test
    void improve_forGuessTwoAndXFour_movesTowardTwo() {
        Sqrt s = new Sqrt(1);
        assertEquals(2.0, s.improve(2.0, 4.0), EPS);
    }

    @Test
    void calc_ofPerfectSquareFour_returnsAboutTwo() {
        assertEquals(2.0, new Sqrt(4.0).calc(), EPS);
    }

    @Test
    void calc_ofPerfectSquareNine_returnsAboutThree() {
        assertEquals(3.0, new Sqrt(9.0).calc(), EPS);
    }

    @Test
    void calc_ofTwo_matchesMathSqrt() {
        assertEquals(Math.sqrt(2.0), new Sqrt(2.0).calc(), EPS);
    }

    @Test
    void calc_ofOne_returnsAboutOne() {
        assertEquals(1.0, new Sqrt(1.0).calc(), EPS);
    }

    @Test
    void calc_ofSmallPositive_matchesMathSqrt() {
        double x = 0.0001;
        assertEquals(Math.sqrt(x), new Sqrt(x).calc(), EPS);
    }

    @Test
    void calc_ofFraction_quarter_returnsAboutHalf() {
        assertEquals(0.5, new Sqrt(0.25).calc(), EPS);
    }
}
