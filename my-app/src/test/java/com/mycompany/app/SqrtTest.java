package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {

  private static final double DELTA = 0.00000001;

  @Test
  public void testAveragePositive() {
    Sqrt sqrt = new Sqrt(4.0);

    assertEquals(3.0, sqrt.average(2.0, 4.0), DELTA);
  }

  @Test
  public void testAverageNegative() {
    Sqrt sqrt = new Sqrt(4.0);

    assertEquals(-3.0, sqrt.average(-2.0, -4.0), DELTA);
  }

  @Test
  public void testGoodTrue() {
    Sqrt sqrt = new Sqrt(4.0);

    assertTrue(sqrt.good(2.0, 4.0));
  }

  @Test
  public void testGoodFalse() {
    Sqrt sqrt = new Sqrt(4.0);

    assertFalse(sqrt.good(1.0, 4.0));
  }

  @Test
  public void testImprove() {
    Sqrt sqrt = new Sqrt(4.0);

    assertEquals(2.0, sqrt.improve(2.0, 4.0), DELTA);
  }

  @Test
  public void testIter() {
    Sqrt sqrt = new Sqrt(9.0);

    assertEquals(3.0, sqrt.iter(1.0, 9.0), DELTA);
  }

  @Test
  public void testCalcPerfectSquare() {
    Sqrt sqrt = new Sqrt(16.0);

    assertEquals(4.0, sqrt.calc(), DELTA);
  }

  @Test
  public void testCalcDecimal() {
    Sqrt sqrt = new Sqrt(2.25);

    assertEquals(1.5, sqrt.calc(), DELTA);
  }

  @Test
  public void testCalcOne() {
    Sqrt sqrt = new Sqrt(1.0);

    assertEquals(1.0, sqrt.calc(), DELTA);
  }

  @Test
  public void testCalcLargeNumber() {
    Sqrt sqrt = new Sqrt(10000.0);

    assertEquals(100.0, sqrt.calc(), DELTA);
  }
}