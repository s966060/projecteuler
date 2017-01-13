package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieve {
    private boolean[] composites;

    public PrimeSieve(int upTo) {
        this.composites = new boolean[upTo + 1];
    }

    public void sieve() {
        int limit = getLimit();

        this.composites[0] = true;
        this.composites[1] = true;
        this.composites[2] = false;

        for (int index = 0; index < limit; ++index) {
            if (!this.composites[index]) {
                int prime = index;

                eliminateComposites(prime);
            }
        }
    }

    private void eliminateComposites(int prime) {
        int multiple = 2;
        int composite;
        composite = prime * multiple;

        while (composite < this.composites.length) {
            this.composites[composite] = true;
            ++multiple;
            composite = prime * multiple;
        }
    }

    private int getLimit() {
        int primeLimit = (int) Math.sqrt(this.composites.length) + 1;
        return Math.min(primeLimit, this.composites.length);
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
                for (int search = index; search < composites.length; ++search) {
                    if (!composites[search]) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Long next() {
                for (int search = index; search < composites.length; ++search) {
                    if (!composites[search]) {
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
                "composites=" + Arrays.toString(composites) +
                '}';
    }
}
