package ru.kashin;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.SynchronousQueue;

import static org.junit.Assert.*;

public class SqrtTest {
    @Test
    public void testSqrtOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(25);
        Assert.assertEquals(5.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(30);
        Assert.assertEquals(Math.sqrt(30), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0);
        Assert.assertEquals(0.0, sqrt.calc(), 0.0001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-25);
        Assert.assertThrows(Throwable.class, sqrt::calc);
    }

    @Test
    public void average() {
        Sqrt s = new Sqrt(0.0);
        double expected = 2.0;
        double actual = s.average(1.0, 3.0);
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void goodTrue() {
        Sqrt s = new Sqrt(0.0);
        Assert.assertTrue(s.good(0.0005, 0.00000025));
    }

    @Test
    public void goodFalse() {
        Sqrt s = new Sqrt(0.0);
        Assert.assertFalse(s.good(0.005, 0.00000025));
    }

    @Test
    public void improve() {
        Sqrt s = new Sqrt(0.0);
        double expected = 3.0;
        double actual = s.improve(1.0, 5.0);
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void iterOne() {
        Sqrt s = new Sqrt(0.0);
        double expected = 1.0;
        double actual = s.iter(1.0, 1.0);
        Assert.assertEquals(expected, actual, 1e-4);
    }
    @Test
    public void iterZero() {
        Sqrt s = new Sqrt(0.0);
        double expected = 0.0;
        double actual = s.iter(1.0, 0.0);
        Assert.assertEquals(expected, actual, 1e-4);
    }
    @Test
    public void calcOne() {
        Sqrt s = new Sqrt(1.0);
        double expected = 1.0;
        double actual = s.calc();
        Assert.assertEquals(expected, actual, 1e-4);
    }
    @Test
    public void calcZero() {
        Sqrt s = new Sqrt(0.0);
        double expected = 0.0;
        double actual = s.calc();
        Assert.assertEquals(expected, actual, 1e-4);
    }
    @Test
    public void calcFour() {
        Sqrt s = new Sqrt(4.0);
        double expected = 2.0;
        double actual = s.calc();
        Assert.assertEquals(expected, actual, 1e-4);
    }
}