package org.fde.util.primes.sieve.store;

import java.util.Arrays;

public class ArrayStore implements Store {
    public final boolean[] numbers;

    public ArrayStore(int upTo) {
        this.numbers = new boolean[upTo + 1];
    }

    @Override
    public boolean isPrime(int index) {
        return !this.numbers[index];
    }

    @Override
    public int getLength() {
        return this.numbers.length;
    }

    @Override
    public void setComposite(int index, boolean isComposite) {
        this.numbers[index] = isComposite;
    }

    @Override
    public String toString() {
        return "ArrayStore{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}