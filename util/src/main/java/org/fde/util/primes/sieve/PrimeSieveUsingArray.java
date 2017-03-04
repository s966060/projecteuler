package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieveUsingArray implements PrimeSieve {
    private boolean[] numbers;

    public PrimeSieveUsingArray(int upTo) {
        this.numbers = new boolean[upTo + 1];
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
        return new Iterator<Long>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                for (int search = index; search < getLength(); ++search) {
                    if (isPrime(search)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Long next() {
                for (int search = index; search < getLength(); ++search) {
                    if (isPrime(search)) {
                        index = search + 1;
                        return (long) search;
                    }
                }

                throw new IllegalArgumentException("no next found");
            }
        };
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

    private boolean isPrime(int index) {
        return !this.numbers[index];
    }

    private int getLength() {
        return this.numbers.length;
    }

    private void setComposite(int index, boolean isComposite) {
        this.numbers[index] = isComposite;
    }
}
