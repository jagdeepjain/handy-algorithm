package org.jagdeep.example.algorithm;

public class Palendrome {
    
    public static void printPalendrome(String stringToCheck) {
        StringBuilder reverseString = new StringBuilder(stringToCheck).reverse();
        if (stringToCheck.equals(reverseString.toString())) {
            System.out.print("Input string is a palendrome.");
        } else {
            System.out.print("Input string is not a palendrome.");
        }
    }
    
    public static void main(String args[]) {
        
        System.out.println("Palendrome: ");
        printPalendrome("aba");
        
    }
    
}
