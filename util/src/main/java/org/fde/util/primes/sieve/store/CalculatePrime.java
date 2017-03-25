package org.fde.util.primes.sieve.store;

public class CalculatePrime {
    private final Store store;
    private final long maximum;

    public CalculatePrime(Store store) {
        this.store = store;
        long maxPrime = new MaxPrime(store).getMaxPrime();
        this.maximum = getMaximum(maxPrime);
    }

    private long getMaximum(long maxPrime) {
        long maximum = maxPrime * maxPrime;

        // overflow
        if (maximum < 0) {
            return Long.MAX_VALUE;
        } else {
            return maximum;
        }
    }

    public boolean isCalculatedPrime(long suspect) {
        if (suspect < 0 || suspect > this.maximum) {
            String msg = String.format("suspect (%s) > maximum (%s)",
                    suspect, this.maximum);

            throw new IllegalArgumentException(msg);
        }

        long length = store.getLength();

        if (suspect < length) {
            boolean isPrime = store.isPrime((int) suspect);
            return isPrime;
        } else {
            long limit = Math.round(Math.sqrt(suspect) + 1);

            for (int index = 2; index < limit; ++index) {
                while (index < length && !store.isPrime(index)) {
                    ++index;
                }

                if (index >= length) {
                    String msg = String.format("index (%s) > store length (%s)",
                            index, length);

                    throw new IllegalArgumentException(msg);
                }

                if ((suspect % index) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
