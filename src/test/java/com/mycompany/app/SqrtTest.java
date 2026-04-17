package com.mycompany.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqrtTest
{
   double delta = 0.0001;

   @Test
   public void sqrt_4() {
      Sqrt sqrt = new Sqrt(4.0);
      Assertions.assertEquals(2.0, sqrt.calc(), delta);
   }

   @Test
   public void sqrt_1() {
      Sqrt sqrt = new Sqrt(1.0);
      Assertions.assertEquals(1.0, sqrt.calc(), delta);
   }

   @Test
   public void sqrt_0() {
      Sqrt sqrt = new Sqrt(0.0);
      Assertions.assertEquals(0.0, sqrt.calc(), delta);
   }

   @Test
   public void sqrt_009() {
      Sqrt sqrt = new Sqrt(0.09);
      Assertions.assertEquals(0.3, sqrt.calc(), delta);
   }

   @Test
   public void sqrt_23104() {
      Sqrt sqrt = new Sqrt(23104.0);
      Assertions.assertEquals(152.0, sqrt.calc(), delta);
   }

   @Test
   public void average_0_10() {
      Sqrt sqrt = new Sqrt(1.0);
      Assertions.assertEquals(5.0, sqrt.average(0.0, 10.0), delta);
   }

   @Test
   public void average_2_5() {
      Sqrt sqrt = new Sqrt(1.0);
      Assertions.assertEquals(3.5, sqrt.average(2.0, 5.0), delta);
   }

   @Test
   public void good_true() {
      Sqrt sqrt = new Sqrt(4.0);
      Assertions.assertTrue(sqrt.good(2.0, 4.0));
   }

   @Test
   public void good_false() {
      Sqrt sqrt = new Sqrt(4.0);
      Assertions.assertFalse(sqrt.good(2.1, 4.0));
   }

   @Test
   public void improve_1_2() {
      Sqrt sqrt = new Sqrt(2.0);
      Assertions.assertEquals(1.5, sqrt.improve(1.0, 2.0), delta);
   }

   @Test
   public void iter_4_4() {
      Sqrt sqrt = new Sqrt(4.0);
      Assertions.assertEquals(2.0, sqrt.iter(4.0, 4.0), delta);
   }

   @Test
   public void iter_40_9() {
      Sqrt sqrt = new Sqrt(9.0);
      Assertions.assertEquals(3.0, sqrt.iter(40.0, 9.0), delta);
   }
}
