package com.fde;

import org.fde.problem_003.PrimeBuilder;

/**
 * Created by filipdelbaen on 14/08/16.
 */
public class SumOfPrimes {
    public static void main(String[] args) {
        PrimeBuilder builder = new PrimeBuilder();

        long sum = 0;
        long prime;

        while((prime = builder.next()) < 2_000_000) {
            sum += prime;
        }

        System.out.println("sum = " + sum);
    }
}
