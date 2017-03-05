package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;

import java.util.BitSet;

public class PrimeSieveUsingBitSet
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final int length;
    private final BitSet numbers;

    public PrimeSieveUsingBitSet(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
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

    void setComposite(int index, boolean isComposite) {
        this.numbers.set(index,isComposite);
    }
}
