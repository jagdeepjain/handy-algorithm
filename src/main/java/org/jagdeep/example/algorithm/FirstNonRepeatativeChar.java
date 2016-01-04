/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example.algorithm;

public class FirstNonRepeatativeChar {
    public static void getFirstNonRepeatativeChar(String intputString) {
        char[] letters = intputString.toCharArray();
        int count = 0;
        
        for (int i = 0; i < letters.length; i++) {
            count = 0;
            for (int j = 0; j < letters.length; j++) {
                if (letters[i] == letters[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("Character '" + letters[i] + "' is the first non repeatative character.");                
                break;
            } 
        }
    }
    
    public static void main(String args[]) {
        getFirstNonRepeatativeChar("abc");
        getFirstNonRepeatativeChar("aabc");
        getFirstNonRepeatativeChar("aabbc");
        getFirstNonRepeatativeChar("aabxfbcc");
    }
}
