package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveFactory {
    public static PrimeSieveAlgorithm createPrimeSieveUsingArray(int upTo) {
        return new PrimeSieveAlgorithm(new ArrayStore(upTo + 1));
    }

    public static PrimeSieveAlgorithm createPrimeSieveUsingBitSet(int upTo) {
        return new PrimeSieveAlgorithm(new BitSetStore(upTo + 1));
    }
}
