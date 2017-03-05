package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveCacheAwareUsingArray {

    public static PrimeSieveCacheAwareAlgorithm createPrimeSieveCacheAwareUsingArray(int upTo) {
        return new PrimeSieveCacheAwareAlgorithm(new ArrayStore(upTo + 1), 1_000_000);
    }
}
