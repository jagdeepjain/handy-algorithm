/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example.algorithm;

public class SwapIntWithoutUsingThirdVariable {
    public static void main(String args[]) {
        int a = -1;
        int b = -2;
        a = a + b;
        b = a - b;
        a = a - b;   
        System.out.println(a + " " + b);
    }
}
