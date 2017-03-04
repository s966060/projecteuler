package org.fde.util.primes.sieve;

import java.util.BitSet;
import java.util.Iterator;

public class PrimeSieveUsingBitSet implements PrimeSieve, PrimeSieveIterable {
    private final int length;
    private final BitSet numbers;

    public PrimeSieveUsingBitSet(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);
    }

    @Override
    public void sieve() {
        int limit = getLimit();

        setComposite(0, true);
        setComposite(1, true);
        setComposite(2, false);

        for (int index = 0; index < limit; ++index) {
            if (isPrime(index)) {
                int prime = index;

                eliminateComposites(prime);
            }
        }
    }

    private void eliminateComposites(int prime) {
        int composite;
        composite = prime + prime;

        while (composite < getLength()) {
            setComposite(composite, true);
            composite += prime;
        }
    }

    private int getLimit() {
        int primeLimit = (int) Math.sqrt(getLength()) + 1;
        return Math.min(primeLimit, getLength());
    }

    @Override
    public Iterable<Long> getPrimes() {
        return getPrimeIterable();
    }

    private Iterable<Long> getPrimeIterable() {
        return () -> getPrimeIterator();
    }

    private Iterator<Long> getPrimeIterator() {
        return new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingBitSet{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }

    boolean[] getNumbers() {
        return null;
    }

    public boolean isPrime(int index) {
        return !this.numbers.get(index);
    }

    public int getLength() {
        return length;
    }

    private void setComposite(int index, boolean isComposite) {
        this.numbers.set(index,isComposite);
    }
}
