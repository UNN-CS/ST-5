package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SqrtTest {
  @Test
  void testAverage() {
    Sqrt sqrt = new Sqrt(4.0);
    assertEquals(2.5, sqrt.average(2.0, 3.0), 1e-9);
    assertEquals(5.0, sqrt.average(4.0, 6.0), 1e-9);
  }

  @Test
  void testGoodTrue() {
    Sqrt sqrt = new Sqrt(4.0);
    assertTrue(sqrt.good(2.0, 4.0));
  }

  @Test
  void testGoodFalse() {
    Sqrt sqrt = new Sqrt(4.0);
    assertFalse(sqrt.good(3.0, 4.0));
  }

  @Test
  void testImprove() {
    Sqrt sqrt = new Sqrt(4.0);
    assertEquals(2.1666666666666665, sqrt.improve(3.0, 4.0), 1e-9);
  }

  @Test
  void testIter() {
    Sqrt sqrt = new Sqrt(4.0);
    assertEquals(2.0, sqrt.iter(1.0, 4.0), 1e-9);
  }

  @Test
  void testCalcFor4() {
    Sqrt sqrt = new Sqrt(4.0);
    assertEquals(2.0, sqrt.calc(), 1e-9);
  }

  @Test
  void testCalcFor2() {
    Sqrt sqrt = new Sqrt(2.0);
    assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-9);
  }

  @Test
  void testCalcFor0_25() {
    Sqrt sqrt = new Sqrt(0.25);
    assertEquals(0.5, sqrt.calc(), 1e-9);
  }

  @Test
  void testCalcFor100() {
    Sqrt sqrt = new Sqrt(100.0);
    assertEquals(10.0, sqrt.calc(), 1e-9);
  }

  @Test
  void testCalcForSmall() {
    Sqrt sqrt = new Sqrt(1e-10);
    double result = sqrt.calc();
    assertEquals(sqrt.arg, result * result, sqrt.delta);
  }

  @Test
  void testGoodDeltaSensitivity() {
    Sqrt sqrt = new Sqrt(100.0);
    assertTrue(sqrt.good(10.0, 100.0));
    assertFalse(sqrt.good(10.1, 100.0));
  }
}
