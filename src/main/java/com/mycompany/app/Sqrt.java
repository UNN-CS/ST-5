package com.mycompany.app;

public class Sqrt
{
   private static final double DELTA = 0.00000001;
   private double arg;

   public Sqrt(double arg) {
      this.arg=arg;
   }
   public double average(double x,double y) {
      return (x+y)/2.0;
   }
   public boolean good(double guess,double x) {
      return Math.abs(guess*guess-x)<DELTA;
   }
   public double improve(double guess,double x) {
      if (guess == 0) {
         throw new IllegalArgumentException("Guess cannot be zero.");
      }
      return average(guess,x/guess);
   }
   public double iter(double guess, double x) {
      while(!good(guess, x)) {
         guess = improve(guess, x);
      }
      return guess;
   }
   public double calc() {
      if (Double.isNaN(arg) || Double.isInfinite(arg)) {
         return arg;
      }
      if (arg < 0) {
         throw new IllegalArgumentException("Cannot calculate square root of a negative number");
      }
      if (arg == 0.0) {
         return 0.0;
      }
      return iter(1.0,arg);
   }
}
