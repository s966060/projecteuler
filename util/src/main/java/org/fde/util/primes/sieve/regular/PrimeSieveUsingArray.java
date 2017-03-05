package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveUsingArray
        extends PrimeSieveAlgorithm {

    private PrimeSieveUsingArray(int upTo) {
        super(new ArrayStore(upTo + 1));
    }

    public static PrimeSieveUsingArray createPrimeSieveUsingArray(int upTo) {
        return new PrimeSieveUsingArray(upTo);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingArray{}";
    }
}
