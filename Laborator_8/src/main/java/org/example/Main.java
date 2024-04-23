package org.example;

public class Main {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = (Integer)calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("5.4.3 a) " + result);

        DoubleCalculator fCalculator = new DoubleCalculator(10);
        double result2 = (Double)fCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("5.4.3 b) "+result2);

        double a =1/0;

    }
}