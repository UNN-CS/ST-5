package com.mycompany.app;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        double val = args.length > 0 ? Double.parseDouble(args[0]) : 2.0;
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.calc();
        System.out.printf(Locale.US, "sqrt(%.4f) = %.10f%n", val, result);
    }
}
