package org.fde.util.primes;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filip on 17/08/2016.
 */
public class PrimeFactors {
    private final Primes primes;

    public PrimeFactors() {
        this.primes = new Primes();
    }

    public ListOfLong getPrimeFactors(long target) {
        PrimeBuilder builder = new PrimeBuilder(this.primes);

        ListOfLong factors = new ListOfLong();

        for (long prime = builder.next(); prime <= target; prime = builder.next()) {
            while ((target % prime) == 0) {
                target /= prime;
                factors.add(prime);
            }
        }

        return factors;
    }

    @Override
    public String toString() {
        return "PrimeFactors{" +
                "primes=" + primes +
                '}';
    }
}
