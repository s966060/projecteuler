package org.fde;

import org.fde.problem_003.PrimeBuilder;

public class The_10001_PrimeNumber {
    public static void main(String[] args) {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 1; i <= 10001; ++i) {
            builder.next();
        }

        long prime = builder.getLastPrime();
        System.out.println("prime = " + prime);
    }
}
