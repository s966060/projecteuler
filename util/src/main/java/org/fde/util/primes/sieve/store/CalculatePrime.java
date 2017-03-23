package org.fde.util.primes.sieve.store;

/**
 * Created by filip on 23/03/2017.
 */
public class CalculatePrime {
    private final Store store;

    public CalculatePrime(Store store) {
        this.store = store;
    }


    public boolean isCalculatedPrime(long suspect) {
        if(suspect < store.getLength()) {
            return store.isPrime((int) suspect);
        }
        else {
            long limit = Math.round(Math.sqrt(suspect) + 1);

            for (int index = 2; index < limit; ++index) {
                while (!store.isPrime(index)) {
                    ++index;
                }

                if ((suspect % index) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
