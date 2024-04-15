package org.example;


import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTest {
    static double DELTA = 1e-4;

    @Test
    public void average() {
        Sqrt s = new Sqrt(0.0);
        double expected = 3.0;
        double actual = s.average(1.0, 5.0);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void goodTrue() {
        Sqrt s = new Sqrt(0.0);
        Assert.assertTrue(s.good(0.04, 0.0016));
    }

    @Test
    public void goodFalse() {
        Sqrt s = new Sqrt(0.0);
        Assert.assertFalse(s.good(0.04, 0.002));
    }

    @Test
    public void improve() {
        Sqrt s = new Sqrt(0.0);
        double expected = 3.0;
        double actual = s.improve(1.0, 5.0);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void improveGuessIsZero() {
        Sqrt s = new Sqrt(0.0);
        double actual = s.improve(0, 5.0);
        Assert.assertTrue(Double.isInfinite(actual));
    }

    @Test
    public void iter() {
        Sqrt s = new Sqrt(0.0);
        double expected = 1.0;
        double actual = s.iter(1.0, 1.0);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcOne() {
        Sqrt s = new Sqrt(1.0);
        double expected = 1.0;
        double actual = s.calc();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcZero() {
        Sqrt s = new Sqrt(0.0);
        double expected = Math.sqrt(0.0);
        double actual = s.calc();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcFour() {
        Sqrt s = new Sqrt(9.04);
        double expected = Math.sqrt(9.04);
        double actual = s.calc();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcNegative() {
        Sqrt s = new Sqrt(-9);
        assertThrows(Throwable.class, s::calc);
    }
}
