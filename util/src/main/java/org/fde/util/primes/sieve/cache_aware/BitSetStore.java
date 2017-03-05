package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.Store;

import java.util.BitSet;

public class BitSetStore implements Store {
    private final int length;
    private final BitSet numbers;

    public BitSetStore(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);
    }

    @Override
    public boolean isPrime(int index) {
        return !this.numbers.get(index);
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setComposite(int index, boolean isComposite) {
        this.numbers.set(index, isComposite);
    }

    @Override
    public String toString() {
        return "BitSetStore{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }
}