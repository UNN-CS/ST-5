package org.st5;


import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class SqrtTest {
    private static final double DELTA = 0.00000001;

    @Test
    public void TestCheckConstructorFunc() {
        Sqrt sqrt = new Sqrt(1);
        assertNotNull(sqrt);
    }

    @Test
    public void TestIterFunc() {
        Sqrt sqrt = new Sqrt(3);
        assertEquals(2.0, sqrt.iter(1, 4), DELTA);
    }

    @Test
    public void TestCalcFunc() {
        Sqrt sqrt = new Sqrt(64);
        assertEquals(8.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFuncBig() {
        Sqrt sqrt = new Sqrt(42810849);
        assertEquals(6543.0, sqrt.calc(), DELTA);
    }

    @Test
    public void TestCalcFuncSmall() {
        Sqrt sqrt = new Sqrt(4e-4);
        assertEquals(0.02, sqrt.calc(), DELTA);
    }

    @Test
    public void TestFindAverageValueFunc() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(4, sqrt.average(4, 4), DELTA);
    }

    @Test
    public void TestFindGoodOddFunc() {
        Sqrt sqrt = new Sqrt(2);
        assertTrue(sqrt.good(2, 4));
        assertFalse(sqrt.good(3, 4));
    }

    @Test
    public void TestImproveFunc() {
        Sqrt sqrt = new Sqrt(2);
        assertEquals(3.5, sqrt.improve(2, 10), DELTA);
    }
}
