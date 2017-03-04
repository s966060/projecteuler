package org.fde.util.primes;

import org.apache.commons.lang3.time.DurationFormatUtils;
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

    private static long TOTAL_ELAPSED =0 ;
    private static final long LOG_THRESHOLD = 1_000_000_000;
    private static long LOG_ELAPSED = LOG_THRESHOLD;

    public boolean contains(long suspect) {
        long start = System.nanoTime();

        try {
            boolean isKnownPrime = this.primes.containsByBinarySearch(suspect);
            return isKnownPrime;
        }
        finally {
            long elapsed = System.nanoTime() - start;
            TOTAL_ELAPSED += elapsed;

            if(TOTAL_ELAPSED > LOG_ELAPSED) {
                LOG_ELAPSED += LOG_THRESHOLD;

                long durationMillis = TOTAL_ELAPSED / 1_000_000;

                System.out.println("@@@ Primes.contains() ... elapsed = "
                        + DurationFormatUtils.formatDurationHMS(durationMillis));
            }
        }
    }
}
