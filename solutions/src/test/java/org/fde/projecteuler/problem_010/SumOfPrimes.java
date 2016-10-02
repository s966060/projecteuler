package org.fde.projecteuler.problem_010;

import org.fde.util.Logger;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfPrimes {
    @Test
    public void sumOfPrimes() {
        PrimeBuilder builder = new PrimeBuilder();

        long sum = 0;
        long prime;

        while ((prime = builder.next()) < 2_000_000) {
            sum += prime;
        }

        Logger.log("sum = " + sum);
        assertEquals(142913828922L, sum);
    }
}
