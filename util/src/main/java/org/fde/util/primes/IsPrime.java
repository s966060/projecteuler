package org.fde.util.primes;

public class IsPrime {
    private final PrimeBuilder factors;

    public IsPrime() {
        this.factors = new PrimeBuilder();
    }

    public boolean isPrime(long suspect) {
        if (suspect < 2) {
            return false;
        }

        if (this.factors.contains(suspect)) {
            return true;
        }

        PrimeBuilder factorIterator = new PrimeBuilder(factors.getPrimes());

        long factor = factorIterator.next();

        while ((factor * factor) <= suspect) {
            if ((suspect % factor) == 0) {
                return false;
            }

            factor = factorIterator.next();
        }

        return true;
    }
}
