package org.algorithm;

public class PrimeNumber {
    
    public static void printPrimeNumbers(int limitNumber) {
        for (int i = 1; i < limitNumber; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + ", ");
            }
        }
    }
    
    public static void main(String args[]) {
        System.out.print("Prime Numbers: ");
        printPrimeNumbers(5);
    }
    
}
