package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieveUsingArray
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private boolean[] numbers;

    public PrimeSieveUsingArray(int upTo) {
        this.numbers = new boolean[upTo + 1];
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
        return "PrimeSieveUsingArray{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    boolean[] getNumbers() {
        return this.numbers;
    }

    public  boolean isPrime(int index) {
        return !this.numbers[index];
    }

    public  int getLength() {
        return this.numbers.length;
    }

    void setComposite(int index, boolean isComposite) {
        this.numbers[index] = isComposite;
    }
}
