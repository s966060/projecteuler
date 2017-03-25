package org.fde.util.primes.sieve.store;

import java.util.Arrays;

public class ArrayStore implements Store {
    public final boolean[] numbers;

    public ArrayStore(int upTo) {
        this.numbers = new boolean[upTo + 1];
    }

    @Override
    public boolean isPrime(long suspect) {
        return !this.numbers[(int) suspect];
    }

    @Override
    public long getLength() {
        return this.numbers.length;
    }

    @Override
    public void setComposite(long value, boolean isComposite) {
        this.numbers[(int) value] = isComposite;
    }

    @Override
    public boolean isCalculatedPrime(long suspect) {
        CalculatePrime calculate = new CalculatePrime(this);
        return calculate.isCalculatedPrime(suspect);
    }

    @Override
    public String toString() {
        return "ArrayStore{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public boolean[] getNumbers() {
        return numbers;
    }
}