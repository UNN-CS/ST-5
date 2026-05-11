package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        double number = Double.parseDouble("2.0");
        NewtonRaphson solver = new NewtonRaphson(number);
        double squareRoot = solver.compute();
        System.out.println("Square root of " + number + " = " + squareRoot);
    }
}