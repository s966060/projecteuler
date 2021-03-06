package org.fde.util.primes.sieve.store;

public class MaxPrime {
    private final Store store;

    public MaxPrime(Store store) {
        this.store = store;
    }

    public long getMaxPrime() {
        for(long index = store.getLength() - 1; index >= 0; --index) {
            if(store.isPrime(index)) {
                return index;
            }
        }

        throw new IllegalArgumentException("not reachable");
    }
}
