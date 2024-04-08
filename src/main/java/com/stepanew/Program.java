package com.stepanew;

class Program {

    public static void main(String[] args) {
/*        double val = Double.parseDouble("2.0");
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.calc();
        System.out.println("Sqrt of " + val + " = " + result);*/
        final var sqrt = new Sqrt(9);
        System.out.println(sqrt.iter(1, 1));
        System.out.println(sqrt.iter(1, 4));
        System.out.println(sqrt.iter(10, 2500));
        System.out.println(sqrt.iter(0, 0));
    }

}
