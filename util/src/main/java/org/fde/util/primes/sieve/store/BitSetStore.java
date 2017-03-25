package org.fde.util.primes.sieve.store;

import java.util.BitSet;

public class BitSetStore implements Store {
    private final int length;
    private final BitSet numbers;

    public BitSetStore(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);
    }

    @Override
    public boolean isPrime(long suspect) {
        return !this.numbers.get((int) suspect);
    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public void setComposite(long value, boolean isComposite) {
        this.numbers.set((int) value, isComposite);
    }

    @Override
    public boolean isCalculatedPrime(long suspect) {
        CalculatePrime calculate = new CalculatePrime(this);
        return calculate.isCalculatedPrime(suspect);
    }

    @Override
    public String toString() {
        return "BitSetStore{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }
}