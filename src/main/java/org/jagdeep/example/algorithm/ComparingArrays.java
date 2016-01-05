/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example.algorithm;

import java.util.Arrays;

public class ComparingArrays {
    public static void main (String[] args) 
    {
        int a1[] = {1, 2, 3};
        int a2[] = {1, 2, 3};
        int a3[] = {1, 2, 4};
        int a4[] = {1, 2, 3};
        
        if (Arrays.equals(a1, a2))
            System.out.println("a1 and a2 are Same.");
        else
            System.out.println("a1 and a2 are not Same.");
        

        if (Arrays.equals(a3, a4))
            System.out.println("a3 and a4 are Same.");
        else
            System.out.println("a3 and a4 are not Same.");
    }
}
