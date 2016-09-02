package org.fde.util.primes;

import java.util.Iterator;

public class PrimeBuilder {
    private final Primes primes;
    private final Squares squares;
    private int index;
    private long currentPrime;

    public PrimeBuilder(Primes primes) {
        this.primes = primes;
        this.index = 0;
        this.squares = new Squares();
    }

    public PrimeBuilder() {
        this(new Primes());
    }

    public long next() {
        if (index < primes.size()) {
            return primes.get(index++);
        }

        nextSuspectPrime:
        for (long suspectPrime = this.primes.last() + 2; ; suspectPrime += 2) {
            // for any number n we now if it is prime if all primes <= sqrt(n) do not divide n
            // if that would not be we would have two number q and p
            // where q <= sqrt(n) and p >= sqrt(n) such that q * p = n and
            // if we try all primes in order from 2...sqrt(n)
            // then q had already have indicated that n is not prime hence p is a superfluous operation

            // now because I don't want to call Math.sqrt()
            // we just make the initial prime feed large enough
            // primes up to 19
            // so for example for 23 the limit of 23 / 4 = 5 is enough
            // only examining 2, 3, 5 else 5 * 5 > 23.
            long limit = getLimit(suspectPrime);

            Iterator<Long> it = this.primes.iterator();
            long prime = it.next();

            while (prime <= limit) {
                long remainder = suspectPrime % prime;

                if (remainder == 0) {
                    continue nextSuspectPrime;
                }

                prime = it.next();
            }

            ++this.index;
            this.primes.add(suspectPrime);
            return suspectPrime;
        }
    }

    private long getLimit(long suspectPrime) {
        this.squares.forward(suspectPrime);
        return this.squares.getCurrentBase();
    }

    public long getLastPrime() {
        return this.primes.last();
    }
}