package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.fde.util.SetOfLong;

public class PrimeFactors {
    private final Primes primes;

    public PrimeFactors() {
        this.primes = new Primes();
    }

    public ListOfLong getPrimeFactors(long target) {
        PrimeBuilder builder = new PrimeBuilder(this.primes);

        ListOfLong factors = new ListOfLong();

        long squareOfPrime = 0;
        long prime = builder.next();

        for (; prime <= target && target > squareOfPrime; prime = builder.next()) {
            while ((target % prime) == 0) {
                target /= prime;
                factors.add(prime);
            }

            squareOfPrime = prime * prime;
        }

        if(target > 1) {
            factors.add(target);
        }

        return factors;
    }

    public SetOfLong getDistinctPrimeFactors(long target) {
        ListOfLong list = getPrimeFactors(target);

        return new SetOfLong(list);
    }

    @Override
    public String toString() {
        return "PrimeFactors{" +
                "primes=" + primes +
                '}';
    }
}
