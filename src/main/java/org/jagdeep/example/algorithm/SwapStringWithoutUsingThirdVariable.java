/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example.algorithm;

public class SwapStringWithoutUsingThirdVariable {

    public static void main(String args[]) {
        String a = "abc";
        String b = "xyz";
        int lengthOfA = a.length();
        int lenghtOfB = b.length();
        int totalLenght = lengthOfA + lenghtOfB;
        
        a = a + b;

        b = a.substring(0, lengthOfA);
        a = a.substring(lengthOfA, totalLenght);
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
