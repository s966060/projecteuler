package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieve {
    private boolean[] numbers;

    public PrimeSieve(int upTo) {
        this.numbers = new boolean[upTo + 1];
    }

    public void sieve() {
        int limit = getLimit();

        this.numbers[0] = true;
        this.numbers[1] = true;
        this.numbers[2] = false;

        for (int index = 0; index < limit; ++index) {
            if (!this.numbers[index]) {
                int prime = index;

                eliminateComposites(prime);
            }
        }
    }

    private void eliminateComposites(int prime) {
        int composite;
        composite = prime + prime;

        while (composite < this.numbers.length) {
            this.numbers[composite] = true;
            composite += prime;
        }
    }

    private int getLimit() {
        int primeLimit = (int) Math.sqrt(this.numbers.length) + 1;
        return Math.min(primeLimit, this.numbers.length);
    }

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
                for (int search = index; search < numbers.length; ++search) {
                    if (!numbers[search]) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Long next() {
                for (int search = index; search < numbers.length; ++search) {
                    if (!numbers[search]) {
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
        return "PrimeSieve{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    boolean[] getNumbers() {
        return this.numbers;
    }
}
