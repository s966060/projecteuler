package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveUsingBitSet {
    public static PrimeSieveAlgorithm createPrimeSieveUsingBitSet(int upTo) {
        return new PrimeSieveAlgorithm(new BitSetStore(upTo + 1));
    }
}
