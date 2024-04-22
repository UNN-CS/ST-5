package org.example;

import junit.framework.TestCase;

public class SqrtTest extends TestCase {

    public void testAverage() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(4.0, sqrt.average(3.0, 5.0), 0.001);
    }

    public void testGood() {
        Sqrt sqrt = new Sqrt(9);
        assertTrue(sqrt.good(4.0, 16));
        assertFalse(sqrt.good(2.9, 9));
    }

    public void testImprove() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.75, sqrt.improve(3.5, 7), 0.001);
    }

    public void testIter() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.iter(1.0, 9), 0.001);
    }

    public void testCalc() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.calc(), 0.001);
    }
}