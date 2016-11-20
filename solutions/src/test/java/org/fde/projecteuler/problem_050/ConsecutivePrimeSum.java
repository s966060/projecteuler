package org.fde.projecteuler.problem_050;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// DAMN UGLY THING OMG
public class ConsecutivePrimeSum {
    private final static long ANSWER = 997651;

    // final long limit = 100;
    // final long limit = 1_000;
    final long LIMIT = 1_000_000;

    @Test
    public void ConsecutivePrimeSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Primes primes = new Primes();

        PrimeBuilder check = new PrimeBuilder(primes);

        boolean done = false;

        Suspect suspect = new Suspect(0, 0, 0, 0);

        for (long wastePrimes = 0; !done; ++wastePrimes) {
            PrimeBuilder builder = new PrimeBuilder(primes);

            if (wastePrimes % 1000 == 0) {
                System.out.println("wastePrimes = " + wastePrimes + " @ " + stopWatch);
            }

            for (long waste = 0; waste < wastePrimes; ++waste) {
                builder.next();
            }

            done = isUseFull(suspect, builder);

            if (done) {
                System.out.println("is not useful anymore starting from waste primes = " + wastePrimes);
                break;
            }

            long prime = builder.next();
            final long firstPrimeTerm = prime;
            int terms = 1;

            if (prime > LIMIT) {
                done = true;
            } else {
                long sum = prime;

                while (sum < LIMIT) {
                    prime = builder.next();
                    ++terms;

                    sum += prime;

                    if (sum < LIMIT) {
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

    private boolean isUseFull(Suspect suspect, PrimeBuilder builder) {
        PrimeBuilder useful = new PrimeBuilder(builder);
        long sum2 = 0;

        for (long i = 1; i <= suspect.getTerms(); ++i) {
            sum2 += useful.next();

        }

        boolean done = sum2 > LIMIT;
        return done;
    }


}
