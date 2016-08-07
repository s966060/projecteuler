package org.fde.problem_003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Primes {
    private final List<Long> primes;

    public Primes() {
        this.primes = new ArrayList<>();
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
}
