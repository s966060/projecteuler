package org.fde.projecteuler.problem_050;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsecutivePrimeSum {
    private final static long ANSWER = 997651;

    @Test
    public void ConsecutivePrimeSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Primes primes = new Primes();

        PrimeBuilder check = new PrimeBuilder(primes);

        // final long limit = 100;
        // final long limit = 1_000;
        final long limit = 1_000_000;

        boolean done = false;

        Suspect suspect = new Suspect(0, 0, 0, 0);

        for (long wastePrimes = 0; !done; ++wastePrimes) {
            PrimeBuilder builder = new PrimeBuilder(primes);

            if(wastePrimes % 1000 == 0) {
                System.out.println("wastePrimes = " + wastePrimes + " @ " + stopWatch);
            }

            for (long waste = 0; waste < wastePrimes; ++waste) {
                builder.next();
            }

            long prime = builder.next();
            final long firstPrimeTerm = prime;
            int terms = 1;

            if (prime > limit) {
                done = true;
            } else {
                long sum = prime;

                while (sum < limit) {
                    prime = builder.next();
                    ++terms;

                    sum += prime;

                    if (sum < limit) {
                        if (check.isPrime(sum)) {
                            if (terms > suspect.getTerms()) {
                                final long lastPrimeTerm = prime;
                                suspect = new Suspect(sum, terms, firstPrimeTerm, lastPrimeTerm);
                                System.out.println("suspect = " + suspect);

                                if (suspect.getPrime() == ANSWER) {
                                    System.out.println("!!! found final answer @ " + stopWatch);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("!!! but the whole algorithm stops @ " + stopWatch);

        System.out.println("!!! suspect = " + suspect);
        assertEquals(suspect.getTerms(), 543);
        assertEquals(suspect.getPrime(), ANSWER);
        assertEquals(suspect.getFirstPrimeTerm(), 7);
        assertEquals(suspect.getLastPrimeTerm(), 3931);
    }


}
