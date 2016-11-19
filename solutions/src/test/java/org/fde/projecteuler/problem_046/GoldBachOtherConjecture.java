package org.fde.projecteuler.problem_046;

import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class GoldBachOtherConjecture {
    @Test
    public void goldBachOtherConjecture() throws Exception {
        Primes primes = new Primes();
        PrimeBuilder builder = new PrimeBuilder(primes);
        boolean found = false;
        Long target = null;

        for (long composite = 3; !found; composite += 2) {
            if (!builder.isPrime(composite)) {
                found = !isGoldBach(composite, primes);

                if (found) {
                    target = composite;
                }
            }
        }

        System.out.println("target = " + target);
        assertEquals(Long.valueOf(5777L), target);
    }

    private boolean isGoldBach(long composite, Primes primes) throws Exception {
        Iterator<Long> it = primes.iterator();
        long prime = it.next();

        while (composite > prime) {
            boolean larger = false;

            for (int j = 1; !larger; ++j) {
                long compute = prime + 2 * (j * j);

                if (compute == composite) {
                    return true;
                }

                larger = compute > composite;
            }

            if (!it.hasNext()) {
                throw new Exception(
                        "primes exhausted...  but it is a composite, " +
                        "and by design there is a prime in the prime list which is > composite, " +
                        "and by the condition composite > prime in the while loop, " +
                        "this is impossible");
            }

            prime = it.next();
        }

        return false;
    }
}
