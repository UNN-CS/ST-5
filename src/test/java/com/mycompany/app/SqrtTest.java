package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SqrtTest {
    private static final double EPS = 1e-8;

    @Test
    public void average_of_two_and_four_is_three() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(3.0, s.average(2.0, 4.0), EPS);
    }

    @Test
    public void average_is_symmetric() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(s.average(1.0, 9.0), s.average(9.0, 1.0), EPS);
    }

    @Test
    public void good_returns_true_when_guess_is_close_enough() {
        Sqrt s = new Sqrt(1.0);
        assertTrue(s.good(2.0, 4.0));
    }

    @Test
    public void good_returns_false_when_guess_is_far() {
        Sqrt s = new Sqrt(1.0);
        assertFalse(s.good(1.0, 4.0));
    }

    @Test
    public void improve_moves_guess_toward_sqrt() {
        Sqrt s = new Sqrt(1.0);
        double next = s.improve(1.0, 4.0);
        assertTrue(Math.abs(next - 2.0) < Math.abs(1.0 - 2.0));
    }

    @Test
    public void improve_keeps_exact_root_stable() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(2.0, s.improve(2.0, 4.0), EPS);
    }

    @Test
    public void iter_returns_guess_when_already_good() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(2.0, s.iter(2.0, 4.0), EPS);
    }

    @Test
    public void iter_converges_for_two_starting_at_one() {
        Sqrt s = new Sqrt(1.0);
        double r = s.iter(1.0, 2.0);
        assertTrue(Math.abs(r * r - 2.0) < s.delta);
    }

    @Test
    public void calc_sqrt_of_two() {
        Sqrt s = new Sqrt(2.0);
        double r = s.calc();
        assertTrue(Math.abs(r * r - 2.0) < s.delta);
    }

    @Test
    public void calc_sqrt_of_four() {
        Sqrt s = new Sqrt(4.0);
        assertEquals(2.0, s.calc(), EPS);
    }

    @Test
    public void calc_sqrt_of_quarter() {
        Sqrt s = new Sqrt(0.25);
        assertEquals(0.5, s.calc(), EPS);
    }

    @Test
    public void constructor_stores_argument_for_calc() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.calc(), EPS);
    }
}
