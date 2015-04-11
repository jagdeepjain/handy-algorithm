package org.algorithm;

public class Palendrome implements Algorithm {
    @Override
    public void run(String stringToCheck) {
        StringBuilder reverseString = new StringBuilder(stringToCheck).reverse();
        if (stringToCheck.equals(reverseString.toString())) {
            System.out.print("Input string is a palendrome.");
        } else {
            System.out.print("Input string is not a palendrome.");
        }
    }
    
    @Override
    public void run(int i) {
        // TODO handle if get integer
    }
    
}
