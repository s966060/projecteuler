package org.fde.projecteuler.problem_007;

import org.fde.util.Logger;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class The_10001_PrimeNumber {
    @Test
    public void the_10001_PrimeNumber() {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 1; i <= 10001; ++i) {
            builder.next();
        }

        long prime = builder.getLastPrime();
        Logger.log("prime = " + prime);

        assertEquals(104743, prime);
    }
}
