package org.algorithm;

public class PrimeNumber implements Algorithm {
    
    public void run(int limitNumber) {
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
        System.out.print("\b\b");
    }
    
    @Override
    public void run(String s) {
        // TODO handle if get string
        
    }
    
}
