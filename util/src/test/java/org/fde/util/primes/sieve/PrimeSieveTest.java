package org.fde.util.primes.sieve;

import org.junit.Test;

public class PrimeSieveTest {
    @Test
    public void primeSieveTest() {
        PrimeSieve sieve = new PrimeSieve(100);

        sieve.sieve();

        System.out.println("sieve = " + sieve);

        for (Long prime : sieve.getPrimes()) {
            System.out.println("prime = " + prime);
        }
    }
}
