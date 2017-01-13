package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieve {
    private boolean[] composites;

    public PrimeSieve(int upTo) {
        this.composites = new boolean[upTo];
    }

    public void sieve() {
        this.composites[0] = true;
        this.composites[1] = true;
        this.composites[2] = false;

        for (int index = 0; index < this.composites.length; ++index) {
            if (!this.composites[index]) {
                int prime = index;

                for (int multiple = 2; prime * multiple < this.composites.length; ++multiple) {
                    this.composites[prime * multiple] = true;
                }
            }
        }
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
