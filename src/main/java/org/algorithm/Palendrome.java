package org.algorithm;

public class Palendrome implements Algorithm {
    @Override
    public void run(String stringToCheck) {
        String reverse = "";
        for (int i = stringToCheck.length() - 1; i >= 0; i--) {
            reverse = reverse + stringToCheck.charAt(i);
        }
        if (stringToCheck.equals(reverse)) {
            System.out.print("Input string is palendrome.");
        } else {
            System.out.print("Input string is not palendrome.");
        }
    }
    
    @Override
    public void run(int i) {
        // TODO handle if get integer
    }
    
}
