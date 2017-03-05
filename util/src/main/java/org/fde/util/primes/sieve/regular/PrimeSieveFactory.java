package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveFactory {
    public static PrimeSieve createPrimeSieveUsingArray(int upTo) {
        ArrayStore store = new ArrayStore(upTo + 1);
        return new PrimeSieve(store);
    }

    public static PrimeSieve createPrimeSieveUsingBitSet(int upTo) {
        BitSetStore store = new BitSetStore(upTo + 1);
        return new PrimeSieve(store);
    }
}
