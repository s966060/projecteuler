package org.fde.util.primes;

import org.fde.util.ListOfLong;

import java.util.Iterator;

public class Primes {

    private final ListOfLong primes;

    public Primes() {
        this.primes = new ListOfLong();
        this.primes.add(2L);
        this.primes.add(3L);
        this.primes.add(5L);
        this.primes.add(7L);
        this.primes.add(11L);
        this.primes.add(13L);
        this.primes.add(17L);
        this.primes.add(19L);
    }

    public Iterator<Long> iterator() {
        return this.primes.iterator();
    }

    public PrimeBuilder getPrimeBuilder() {
        return new PrimeBuilder(this);
    }

    public int size() {
        return this.primes.size();
    }

    public Long get(int index) {
        return this.primes.get(index);
    }

    public Long last() {
        return get(size() - 1);
    }

    public void add(long prime) {
        this.primes.add(prime);
    }

    @Override
    public String toString() {
        return "Primes{" +
                "primes=" + primes +
                '}';
    }

    public boolean contains(long suspect) {
        boolean isKnownPrime = this.primes.containsByBinarySearch(suspect);
        return isKnownPrime;
    }
}
