/**
 * @author jagdeepjain
 *
 */
package org.algorithm;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithm) {
        if (algorithm.equalsIgnoreCase("factorial")) {
            return new Factorial();
        } else if (algorithm.equalsIgnoreCase("palendrome")) {
            return new Palendrome();
        } else if (algorithm.equalsIgnoreCase("prime")) {
            return new PrimeNumber();
        } else {
            return null;
        }
    }
}
