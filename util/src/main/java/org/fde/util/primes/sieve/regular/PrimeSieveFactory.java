package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveFactory {
    public static PrimeSieve createPrimeSieveUsingArray(int upTo) {
        return new PrimeSieve(new ArrayStore(upTo + 1));
    }

    public static PrimeSieve createPrimeSieveUsingBitSet(int upTo) {
        return new PrimeSieve(new BitSetStore(upTo + 1));
    }
}
