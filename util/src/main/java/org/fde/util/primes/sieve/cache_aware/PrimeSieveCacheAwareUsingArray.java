package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveCacheAwareUsingArray
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

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
