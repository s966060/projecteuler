package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveUsingArray
        extends PrimeSieveAlgorithm {

    public PrimeSieveUsingArray(int upTo) {
        super(new ArrayStore(upTo + 1));
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingArray{}";
    }
}
