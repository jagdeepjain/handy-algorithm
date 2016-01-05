/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example.algorithm;

public class Fibonacci {
    
    public static void main(String args[]) {
        int sum = 0, first = 0, second = 1;
        
        System.out.println(first);
        System.out.println(second);
        
        for (int i = 2; i < 10; i++) {
           sum = first + second;
           
           System.out.println(sum);
           
           first = second;
           second = sum; 
        }
    }
}
