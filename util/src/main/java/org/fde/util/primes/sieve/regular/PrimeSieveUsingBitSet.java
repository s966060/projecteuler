package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveUsingBitSet
        extends PrimeSieveAlgorithm {

    private PrimeSieveUsingBitSet(int upTo) {
        super(new BitSetStore(upTo + 1));
    }

    public static PrimeSieveUsingBitSet createPrimeSieveUsingBitSet(int upTo) {
        return new PrimeSieveUsingBitSet(upTo);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingBitSet{}";
    }
}
