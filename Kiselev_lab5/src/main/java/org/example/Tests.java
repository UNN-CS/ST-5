package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    void testConstructor() {
        Assertions.assertDoesNotThrow(() -> {Sqrt s = new Sqrt(2.0);});
        Assertions.assertDoesNotThrow(() -> {Sqrt s = new Sqrt(-2.0);});
        Assertions.assertDoesNotThrow(() -> {Sqrt s = new Sqrt(123456789.0);});
        Assertions.assertDoesNotThrow(() -> {Sqrt s = new Sqrt(0.23556);});
        Assertions.assertDoesNotThrow(() -> {Sqrt s = new Sqrt(123.432);});
    }
    @Test
    void testAverage() {
        Sqrt s = new Sqrt(2.0);
        Assertions.assertEquals(s.average(2.0, 0.0), 1.0, s.delta);
        Assertions.assertEquals(s.average(12.5, 13.0), 12.75, s.delta);
        Assertions.assertEquals(s.average(2.0, -2.0), 0.0, s.delta);
    }
    @Test
    void testGood() {
        Sqrt s = new Sqrt(2.0);
        Assertions.assertTrue(s.good(2.0,4.0));
        Assertions.assertTrue(s.good(2.0,3.999999999));
        Assertions.assertTrue(s.good(-2.0,4.0));
        Assertions.assertFalse(s.good(2.0,3.999));
    }
    @Test
    void testImprove() {
        Sqrt s = new Sqrt(2.0);
        Assertions.assertEquals(s.improve(2.0, 2.0), 1.5, s.delta);
        Assertions.assertEquals(s.improve(2.0, 4.0), 2.0, s.delta);
        Assertions.assertEquals(s.improve(2.0, 0), 1.0, s.delta);
    }
    @Test
    void testIter() {
        Sqrt s = new Sqrt(2.0);
        Assertions.assertEquals(s.iter(1.0, 4.0), 2.0, s.delta);
        Assertions.assertEquals(s.iter(1.0, 2.0), 1.4142135623746899, s.delta);
        Assertions.assertEquals(s.iter(2.0, 2.0), 1.4142135623746899, s.delta);
    }
    @Test
    void testCalc() {
        Sqrt s = new Sqrt(2.0);
        Assertions.assertEquals(s.calc(), 1.4142135623746899, s.delta);
        s = new Sqrt(4.0);
        Assertions.assertEquals(s.calc(), 2.0, s.delta);
        s = new Sqrt(9.0);
        Assertions.assertEquals(s.calc(), 3.0, s.delta);
        s = new Sqrt(1024.0);
        Assertions.assertEquals(s.calc(), 32.0, s.delta);
    }
}
