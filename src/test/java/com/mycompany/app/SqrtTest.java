package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {

    private static final double DELTA = 0.0001;

    // calc() tests
    @Test
    public void testCalcOf1() {
        assertEquals(1.0, new Sqrt(1.0).calc(), DELTA);
    }

    @Test
    public void testCalcOf4() {
        assertEquals(2.0, new Sqrt(4.0).calc(), DELTA);
    }

    @Test
    public void testCalcOf9() {
        assertEquals(3.0, new Sqrt(9.0).calc(), DELTA);
    }

    @Test
    public void testCalcOf2() {
        assertEquals(Math.sqrt(2.0), new Sqrt(2.0).calc(), DELTA);
    }

    @Test
    public void testCalcOf0dot25() {
        assertEquals(0.5, new Sqrt(0.25).calc(), DELTA);
    }

    // average() tests
    @Test
    public void testAverageSymmetric() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(s.average(2.0, 4.0), s.average(4.0, 2.0), DELTA);
    }

    @Test
    public void testAverageBasic() {
        assertEquals(3.0, new Sqrt(1.0).average(2.0, 4.0), DELTA);
    }

    // good() tests
    @Test
    public void testGoodExactRoot() {
        assertTrue(new Sqrt(4.0).good(2.0, 4.0));
    }

    @Test
    public void testGoodBadGuess() {
        assertFalse(new Sqrt(4.0).good(1.0, 4.0));
    }

    // improve() test
    @Test
    public void testImproveConverges() {
        Sqrt s = new Sqrt(4.0);
        double improved = s.improve(1.0, 4.0);
        assertTrue(Math.abs(improved * improved - 4.0) < Math.abs(1.0 * 1.0 - 4.0));
    }

    // iter() test
    @Test
    public void testIterReturnsGoodGuess() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.iter(1.0, 9.0), DELTA);
    }

    // edge case: large number
    @Test
    public void testCalcLargeNumber() {
        assertEquals(Math.sqrt(10000.0), new Sqrt(10000.0).calc(), DELTA);
    }
}
