package org.fde.util.primes.sieve.store;

import java.util.BitSet;

public class MultiBitSetStore implements Store {
    private final int length;
    private final BitSet[] numbers;

    // requiring BUCKET_SIZE = 2^n
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
        BitSet bucket = getBucket(suspect);
        int index = getIndexInBucket(suspect);

        return !bucket.get(index);
    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public void setComposite(long suspect, boolean isComposite) {
        BitSet bucket = getBucket(suspect);
        int index = getIndexInBucket(suspect);

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

    private BitSet getBucket(long suspect) {
        int bucketSelector = (int) (suspect / BUCKET_SIZE);
        return this.numbers[bucketSelector];
    }

    private int getIndexInBucket(long suspect) {
        return (int) (suspect % BUCKET_SIZE);
    }
}
