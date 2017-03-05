package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;

import java.util.Arrays;

public class PrimeSieveUsingArray
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private boolean[] numbers;

    public PrimeSieveUsingArray(int upTo) {
        this.numbers = new boolean[upTo + 1];
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingArray{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public boolean[] getNumbers() {
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
