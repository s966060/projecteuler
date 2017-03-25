package org.fde.util.primes.sieve.store;

import java.util.BitSet;

public class MultiBitSetStore implements Store {
    private final int length;
    private final BitSet[] numbers;

    private final static int BUCKET_SIZE = 1024;

    public MultiBitSetStore(int upTo) {
        this.length = upTo + 1;

        int arraySize = (length / BUCKET_SIZE) + 1;

        if((length % BUCKET_SIZE) == 0) {
            --arraySize;
        }

        this.numbers = new BitSet[arraySize];

        for(int index = 0; index < arraySize; ++index) {
            this.numbers[index] = new BitSet(BUCKET_SIZE);
        }
    }

    @Override
    public boolean isPrime(long suspect) {
        int bucketSelector = (int) (suspect / BUCKET_SIZE);
        BitSet bucket = this.numbers[bucketSelector];

        int index = (int) (suspect % BUCKET_SIZE);

        return !bucket.get(index);
    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public void setComposite(long suspect, boolean isComposite) {
        int bucketSelector = (int) (suspect / BUCKET_SIZE);
        BitSet bucket = this.numbers[bucketSelector];

        int index = (int) (suspect % BUCKET_SIZE);

        bucket.set(index, isComposite);
    }

    @Override
    public boolean isCalculatedPrime(long suspect) {
        CalculatePrime calculate = new CalculatePrime(this);
        return calculate.isCalculatedPrime(suspect);
    }

    @Override
    public String toString() {
        return "BitSetStore{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }
}
