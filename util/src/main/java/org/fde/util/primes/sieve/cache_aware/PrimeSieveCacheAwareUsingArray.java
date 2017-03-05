package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveCacheAwareUsingArray
        extends PrimeSieveCacheAwareAlgorithm {

    private PrimeSieveCacheAwareUsingArray(int upTo) {
        super(new ArrayStore(upTo + 1), 1_000_000);
    }

    public static PrimeSieveCacheAwareUsingArray createPrimeSieveCacheAwareUsingArray(int upTo) {
        return new PrimeSieveCacheAwareUsingArray(upTo);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingArray{}";
    }
}
