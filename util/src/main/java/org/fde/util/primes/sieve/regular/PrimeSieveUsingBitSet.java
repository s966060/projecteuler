package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveUsingBitSet
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final BitSetStore store;

    public PrimeSieveUsingBitSet(int upTo) {
        this.store = new BitSetStore(upTo);
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingBitSet{" +
                "store=" + store +
                '}';
    }

    public boolean isPrime(int index) {
        return store.isPrime(index);
    }

    public int getLength() {
        return store.getLength();
    }

    void setComposite(int index, boolean isComposite) {
        store.setComposite(index, isComposite);
    }
}
