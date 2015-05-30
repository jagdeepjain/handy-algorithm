/**
 * @author jagdeepjain
 *
 */
package org.algorithm.techgig.codegladiator;

/*
 * A teacher play a interesting game in the class. He select some n students of the class 
 * and make a row of these n students ( where 0<=n<=1000 ). He makes the row randomly. He
 * puts a very interesting question to the remaining student of the class. He told them to 
 * select some of the student out of the row such that when we make the string using the 
 * first character of their names ( consider only the first name ) that string becomes a 
 * palindrome (Palindrome is a string which is equal to the reverse of itself example ASPDPSA)
 * of the longest length possible. The condition is that the string which is constructed using
 * the first character of students should be constructed in a way that the characters should 
 * come in the same order in which the students are standing in the row. You have to answer
 * the length of longest possible palindrome.
 * 
 *  Input/Output Specification
 *  
 *  Input Specification:
 *  a list of students
 *  
 *  Output Specifications : 
 *  length of longest palindrome constructed using the first characters of student in any
 *  sublist of the input student list.
 * 
 * Examples
 * Lets teacher selects following studen to make row.
 * {Bharti,Bharat,Akash,Bhavya,Chand,Brijesh,Chetak,Arvind,Bhavna} and put the questio to
 * select some student out of the row.
 * 
 * One students select- Bharti,Bharat,Bhavya,Brijesh,Bhavna
 * String-BBBBBB: This is a palindrome of length 5
 * 
 * Another student select-Bharti,Bharat,Chand,Brijesh,Bhavna
 * String-BBCBB: This is a palindrome of length 5
 * 
 * Third student selects-Bharti,Akash,Bhavya,Chand,Brijesh,Arvind,Bhavna
 * String-BABCBAB: This is a palindrome of length 7 (longest possible for this example)
 * 
 * 
 */

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class PalindromePuzzle {
    
    private PalindromePuzzle() {}
    
    public static int PalindromeLengthPuzzle(String[] input1) {
        final StringBuilder studentInitials = new StringBuilder();
        for (String name : input1) {
            studentInitials.append(name.charAt(0));
        }
        
        class Palindrome {
            // stores palindrome strings
            private Set<String> studentInitialsPalindrome = new TreeSet<String>();
            // constructor
            private Palindrome() {}
            
            // get combination of studentInitials
            public void getCombinations(String initials) {
                getCombinations("", initials);
            }
            
            private void getCombinations(String subString, String initials) {
                if (isPalindrome(subString)) {
                    studentInitialsPalindrome.add(subString);
                }
                for (int i = 0; i < initials.length(); i++) {
                    getCombinations(subString + initials.charAt(i),
                            initials.substring(i + 1));
                }
            }
            
            // reverse the string and check palindrome
            private boolean isPalindrome(String stringToCheck) {
                String reverse = "";
                boolean isPalindrome = false;
                for (int i = stringToCheck.length() - 1; i >= 0; i--) {
                    reverse = reverse + stringToCheck.charAt(i);
                }
                if (stringToCheck.equals(reverse)) {
                    isPalindrome = true;
                }
                return isPalindrome;
            }
            
            // get length of biggest palindrome
            public int getMaxLength() {
                int maxLength = 0;
                for (String string : studentInitialsPalindrome) {
                    if (string.length() > maxLength) {
                        maxLength = string.length();
                    }
                }
                return maxLength;
            }
        }
        
        Palindrome palindrome = new Palindrome();
        palindrome.getCombinations(studentInitials.toString());
        
        return palindrome.getMaxLength();
    }
    
    public static void main(String args[]) {
        String[] studentList = { "Bharti", "Bharat", "Akash", "Bhavya",
                "Chand", "Brijesh", "Chetak", "Arvind", "Bhavna" };
        System.out.println(PalindromeLengthPuzzle(studentList));
    }
    
}
