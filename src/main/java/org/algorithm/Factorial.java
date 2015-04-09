package org.algorithm;

public class Factorial implements Algorithm {
    public void run(int numberLimit) {
        int limit = numberLimit;
        for (int i = 1; i <= limit; i++) {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            System.out.print(factorial + ", ");
        }
    }
    
    @Override
    public void run(String s) {
        // TODO handle if get string
    }
}
