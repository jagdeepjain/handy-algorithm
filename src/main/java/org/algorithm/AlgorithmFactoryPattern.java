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
		((Factorial) factorial).getFactorial(5);
		System.out.println("\n");

		System.out.println("Palendrome:");
		Algorithm palendrome = algorithm.getAlgorithm("palendrome");
		((Palendrome) palendrome).getPalendrome("aba");
		System.out.println("\n");

		System.out.println("Prime Numbers:");
		Algorithm primeNumber = algorithm.getAlgorithm("prime");
		((PrimeNumber) primeNumber).getPrimeNumers(5);
		System.out.println("\n");
	}
}
