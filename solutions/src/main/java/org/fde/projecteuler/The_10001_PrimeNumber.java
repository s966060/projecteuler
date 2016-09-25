package org.fde.projecteuler;

import org.fde.util.Logger;
import org.fde.util.primes.PrimeBuilder;

public class The_10001_PrimeNumber {
    public static void main(String[] args) {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 1; i <= 10001; ++i) {
            builder.next();
        }

        long prime = builder.getLastPrime();
        Logger.log("prime = " + prime);
    }
}