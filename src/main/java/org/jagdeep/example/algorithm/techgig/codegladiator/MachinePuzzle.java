package org.jagdeep.example.algorithm.techgig.codegladiator;

/*
 * A Machine M1 takes a sequence of numbers as input and outputs another sequence. Let input 
 * sequence be x1, x2,..,xN. Difference x2-x1 is called 1st step difference, x3-x3 is called 
 * 2nd steps difference ,......, xN-xN-1 is called (n-1)th steps difference. Thus these step 
 * differences make a new sequence. So, machine M1 calculates these step differences and 
 * outputs this new sequence formed. If input sequence is of length 1 then it just outputs 
 * the input sequence. Now a new Machine M2 is formed which takes a sequence as input and 
 * uses this machine M1 and outputs a sequence. A flag value 'f' is associated with machine 
 * M2 which will be 0 or 1 or 2. Working of machine M2 is shown in the following figure:
 *                  
 * Input Sequence A
 *   |
 *   |  |---------------------------------------------------------------------|
 *   |  |                                             |---------------------| |
 *   |  |                                             |  Make f = 2         | |
 *   |  |                                             |  if input sequence  | |
 *   |  |                                         |-=>|  is of length 1     | |
 *   |  |                                         |   |  otherwise f is     | |
 *   |  |                                         |   |  unchanged          | |
 *   |  |                                         |   |---------------------| |
 *   |  |   |-----------------------|             |                           |
 *   |  |   |    Select sequence    |   |-------| }                           |
 *   |  |   |    A if f = 0 and     |-->|  M2   |-----------------------------|--> Output                
 *   |----->|    make f = 1         |   |-------| |                           | 
 *      |   |    otherwise select   |             |                           |
 *      | ->|    sequence 8 and     |             |                           |
 *      | | |    keep f unchanged   |             |                           |
 *      | | |-----------------------|             |                           |
 *      | |---------------------------------------|                           |  
 *      |              Sequence B                                             |
 *      |---------------------------------------------------------------------|
 *                              Working of Machine M2
 *                       
 *                       
 * We say that Machine M2's output is valid when flag 'f' becomes 2. You have to tell the 
 * valid output of M2 for the given input sequence assuming that when the input was given, 
 * flag 'f' was 0.
 * 
 * Input/Output Specifications
 * Input Specification:
 * Input should be sequence of numbers(string) which will be given as as input to machine M2.
 * 
 * Output Specification:
 * Out should be the valid output(string) of machine M2.
 * 
 * Input: 1, 5, 9, 2, 3, 5, 6
 * Output: 87
 * 
 * Example:
 * I am giving the way to find the answer for test case 1. Similarly you can check for the 
 * other test cases. You have to find just the step differences for each new sequence formed 
 * by machine M1 until you get the sequence of length 1 (i.e. a number), that number will be 
 * the output.
 * 
 * 1    5    9    2    3    5    6
 *   4    4    -7    1    2    1
 *      0   -11   8    1    -1
 *       -11   19   -7   -2
 *          30   -26   5
 *            -56   31
 *                87
 *                
 *      
 */

import java.io.*;

public class MachinePuzzle {
    public static String sequences(String input1) {
        
        String machine2output = "";
        final String input = input1;
        
        class MachineSequence {
            private MachineSequence() {
            }
            
            private int firstSequenceLength;
            private String[] steps;
            private int[] orginalSteps;
            
            private void setInputSequence() {
                String inputSequence = input;
                steps = inputSequence.split(",");
            }
            
            private int[] getSteps() {
                firstSequenceLength = steps.length;
                orginalSteps = new int[firstSequenceLength];
                int counter = 0;
                for (String step : steps) {
                    orginalSteps[counter] = Integer.parseInt(step);
                    counter++;
                }
                return orginalSteps;
            }
            
            private int machine2Output() {
                int numberOfSteps = firstSequenceLength;
                for (int i = 0; i < numberOfSteps;) {
                    if (i == (numberOfSteps - 1)) {
                        i = 0;
                        numberOfSteps = numberOfSteps - 1;
                        continue;
                    }
                    orginalSteps[i] = orginalSteps[i + 1] - orginalSteps[i];
                    i++;
                }
                return orginalSteps[0];
            }
        }
        
        MachineSequence machineSequence = new MachineSequence();
        machineSequence.setInputSequence();
        machineSequence.getSteps();
        
        machine2output = "" + machineSequence.machine2Output();
        
        return machine2output;
    }
    
    public static void main(String args[]) {
        System.out.println(sequences("1,5,9,2,3,5,6"));
    }
}