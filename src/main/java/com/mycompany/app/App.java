package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            double val = Double.parseDouble(args[0]);
            Sqrt sqrt = new Sqrt(val);
            double result = sqrt.calc();
            System.out.println("Sqrt of " + val + " = " + result);
        } else {
            double val = 2.0;
            Sqrt sqrt = new Sqrt(val);
            double result = sqrt.calc();
            System.out.println("Sqrt of " + val + " = " + result);
        }
    }
}