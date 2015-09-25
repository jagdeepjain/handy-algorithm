package org.jagdeep.example.algorithm;

public class Factorial {
    
    public static void printFactorial(int numberLimit) {
        int limit = numberLimit;
        for (int i = 1; i <= limit; i++) {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            System.out.print(factorial + ", ");
        }
    }
    
    public static void main(String args[]) {

        System.out.print("Factorial: ");
        printFactorial(5);
    }
}
