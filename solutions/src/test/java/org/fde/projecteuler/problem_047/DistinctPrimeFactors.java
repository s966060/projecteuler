package org.fde.projecteuler.problem_047;

import org.fde.util.SetOfLong;
import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistinctPrimeFactors {

    @Test
    public void distinctPrimeFactors() throws Exception {
        PrimeFactors factors = new PrimeFactors();

        Found found = new Found();

        for (int number = 0; !found.found(); ++number) {
            SetOfLong primeFactors = factors.getDistinctPrimeFactors(number);

            if (primeFactors.size() == 4) {
                found.add(number);
            }
        }

        System.out.println("found = " + found);
        assertEquals(Long.valueOf(134043L), found.list.first());
    }
}
