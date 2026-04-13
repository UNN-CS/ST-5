package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

   private static final double EPS = 1e-7;

   @Test
   void constructorStoresArgumentUsedByCalc() {
      Sqrt sqrt = new Sqrt(25.0);
      assertEquals(5.0, sqrt.calc(), EPS);
   }

   @Test
   void averageOfTwoNumbers() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(2.5, sqrt.average(2.0, 3.0), EPS);
   }

   @Test
   void averageWithNegativeOperands() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(0.0, sqrt.average(-3.0, 3.0), EPS);
   }

   @Test
   void averageOfIdenticalValues() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(7.0, sqrt.average(7.0, 7.0), EPS);
   }

   @Test
   void averageOfLargeValues() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(2.0e9, sqrt.average(1.0e9, 3.0e9), 1.0);
   }

   @Test
   void goodIsTrueWhenGuessSquaredIsCloseToX() {
      Sqrt sqrt = new Sqrt(1.0);
      double x = 2.0;
      double guess = Math.sqrt(2.0);
      assertTrue(sqrt.good(guess, x));
   }

   @Test
   void goodIsFalseWhenGuessIsFarFromRoot() {
      Sqrt sqrt = new Sqrt(1.0);
      assertFalse(sqrt.good(1.0, 100.0));
   }

   @Test
   void goodIsTrueForExactPerfectRoot() {
      Sqrt sqrt = new Sqrt(1.0);
      assertTrue(sqrt.good(10.0, 100.0));
   }

   @Test
   void goodIsFalseWhenGuessDoesNotMatchX() {
      Sqrt sqrt = new Sqrt(1.0);
      assertFalse(sqrt.good(2.0, 81.0));
   }

   @Test
   void improveMovesGuessTowardSquareRoot() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(1.5, sqrt.improve(1.0, 2.0), EPS);
   }

   @Test
   void improveLeavesOptimalGuessUnchanged() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(3.0, sqrt.improve(3.0, 9.0), EPS);
   }

   @Test
   void improveSecondNewtonStepForNine() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(3.25, sqrt.improve(2.0, 9.0), EPS);
   }

   @Test
   void iterReturnsImmediatelyWhenGuessIsGood() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(3.0, sqrt.iter(3.0, 9.0), EPS);
   }

   @Test
   void iterConvergesThroughRecursion() {
      Sqrt sqrt = new Sqrt(1.0);
      double root = sqrt.iter(1.0, 2.0);
      assertEquals(Math.sqrt(2.0), root, EPS);
   }

   @Test
   void iterReturnsWhenStartingFromPerfectRoot() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(4.0, sqrt.iter(4.0, 16.0), EPS);
   }

   @Test
   void calcComputesSquareRootOfTwo() {
      Sqrt sqrt = new Sqrt(2.0);
      assertEquals(Math.sqrt(2.0), sqrt.calc(), EPS);
   }

   @Test
   void calcComputesSquareRootOfPerfectSquare() {
      Sqrt sqrt = new Sqrt(144.0);
      assertEquals(12.0, sqrt.calc(), EPS);
   }

   @Test
   void calcComputesSquareRootOfFraction() {
      Sqrt sqrt = new Sqrt(0.25);
      assertEquals(0.5, sqrt.calc(), EPS);
   }

   @Test
   void calcComputesSquareRootOfLargeValue() {
      Sqrt sqrt = new Sqrt(1.0e12);
      assertEquals(1.0e6, sqrt.calc(), 1.0e-4);
   }

   @Test
   void calcComputesSquareRootOfThree() {
      Sqrt sqrt = new Sqrt(3.0);
      assertEquals(Math.sqrt(3.0), sqrt.calc(), EPS);
   }

   @Test
   void calcComputesSquareRootOfFortyNine() {
      Sqrt sqrt = new Sqrt(49.0);
      assertEquals(7.0, sqrt.calc(), EPS);
   }

   @Test
   void calcComputesSquareRootOfOne() {
      Sqrt sqrt = new Sqrt(1.0);
      assertEquals(1.0, sqrt.calc(), EPS);
   }
}
