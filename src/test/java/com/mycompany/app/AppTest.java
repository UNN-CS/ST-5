package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.Sqrt;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test4to2() {
        Sqrt sq = new Sqrt(4);
        assertTrue((sq.calc() - 2.0) < 0.001);
    }

    @Test
    public void testThrows() {
        //Sqrt sq = new Sqrt(4);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Sqrt(-4);
        });

        assertEquals("cannot take real square root from arg < 0", exception.getMessage());
    }

    @Test
    public void test10000to100() {
        Sqrt sq = new Sqrt(10000);
        assertTrue((sq.calc() - 100.0) < 0.001);
    }

    @Test
    public void test009to03() {
        Sqrt sq = new Sqrt(0.09);
        assertTrue((sq.calc() - 0.3) < 0.001);
    }

    @Test
    public void test1to1() {
        Sqrt sq = new Sqrt(1.0);
        assertTrue((sq.calc() - 1.0) < 0.001);
    }

    @Test
    public void test0to0() {
        Sqrt sq = new Sqrt(0.0);
        assertTrue((sq.calc() - 0.0) < 0.001);
    }

    @Test
    public void test2tosq0() {
        Sqrt sq = new Sqrt(2.0);
        assertTrue((sq.calc() - 1.41421356237) < 0.001);
    }

    @Test
    public void test1000tosq1000() {
        Sqrt sq = new Sqrt(1000.0);
        assertTrue((sq.calc() - 31.6227766017) < 0.001);
    }

    @Test
    public void test02tosq02() {
        Sqrt sq = new Sqrt(0.2);
        assertTrue((sq.calc() - 0.4472135955) < 0.001);
    }

    @Test
    public void testThrowsOnSmallArgValue() {
        //Sqrt sq = new Sqrt(4);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Sqrt(-0.0001);
        });

        assertEquals("cannot take real square root from arg < 0", exception.getMessage());
    }
}
