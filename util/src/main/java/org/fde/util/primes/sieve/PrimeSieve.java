package org.fde.util.primes.sieve;

public interface PrimeSieve {
    void sieve();
    Iterable<Long> getPrimes();
}
