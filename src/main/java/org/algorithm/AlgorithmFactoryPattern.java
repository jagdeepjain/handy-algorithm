/**
 * @author jagdeepjain
 *
 */
package org.algorithm;

public class AlgorithmFactoryPattern {
    
    public static void main(String args[]) {
        AlgorithmFactory algorithm = new AlgorithmFactory();
        
        System.out.println("Factorial:");
        Algorithm factorial = algorithm.getAlgorithm("factorial");
        factorial.run(5);
        System.out.println("\n");
        
        System.out.println("Palendrome:");
        Algorithm palendrome = algorithm.getAlgorithm("palendrome");
        palendrome.run("aba");
        System.out.println("\n");
        
        System.out.println("Prime Numbers:");
        Algorithm primeNumber = algorithm.getAlgorithm("prime");
        primeNumber.run(5);
        System.out.println("\n");
    }
}
