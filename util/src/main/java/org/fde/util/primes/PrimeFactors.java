package org.fde.util.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filip on 17/08/2016.
 */
public class PrimeFactors {
    public static List<Long> getPrimeFactors(long target) {
        PrimeBuilder builder = new PrimeBuilder();

        List<Long> factors = new ArrayList<>();

        for (long prime = builder.next(); prime <= target; prime = builder.next()) {
            while ((target % prime) == 0) {
                target /= prime;
                factors.add(prime);
            }
        }

        return factors;
    }
}
