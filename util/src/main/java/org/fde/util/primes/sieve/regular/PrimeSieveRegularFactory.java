package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveRegularFactory {
    public static PrimeSieveRegular createPrimeSieveUsingArray(int upTo) {
        ArrayStore store = new ArrayStore(upTo + 1);
        return new PrimeSieveRegular(store);
    }

    public static PrimeSieveRegular createPrimeSieveUsingBitSet(int upTo) {
        BitSetStore store = new BitSetStore(upTo + 1);
        return new PrimeSieveRegular(store);
    }
}
