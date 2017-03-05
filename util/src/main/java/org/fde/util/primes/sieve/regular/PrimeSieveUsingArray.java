package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveUsingArray {
    public static PrimeSieveAlgorithm createPrimeSieveUsingArray(int upTo) {
        return new PrimeSieveAlgorithm(new ArrayStore(upTo + 1));
    }
}
