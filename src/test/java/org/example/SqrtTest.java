package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {

    @Test
    public void average() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 0.001);
    }

    @Test
    public void good() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4));
        assertFalse(sqrt.good(1.9, 4));
    }

    @Test
    public void improve() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.05, sqrt.improve(2.5, 4), 0.001);
    }

    @Test
    public void iter() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(1.0, 4), 0.001);
    }

    @Test
    public void calc() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), 0.001);
    }
}
