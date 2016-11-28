package org.fde.projecteuler.problem_051;

import org.fde.util.ListOfLong;

import java.util.Arrays;

public class ReplaceFamily {
    private final long canonicalSuspect;

    private final int[] replaceIndexes;
    private final ListOfLong familyPrimes;

    public ReplaceFamily(long canonicalSuspect, int[] replaceIndexes, ListOfLong familyPrimes) {
        this.canonicalSuspect = canonicalSuspect;
        this.replaceIndexes = Arrays.copyOf(replaceIndexes, replaceIndexes.length);
        this.familyPrimes = familyPrimes;
    }

    @Override
    public String toString() {
        return "ReplaceFamily{" +
                "canonicalSuspect=" + canonicalSuspect +
                ", replaceIndexes=" + Arrays.toString(replaceIndexes) +
                ", familyPrimes=" + familyPrimes +
                '}';
    }

    public int getFamilyCount() {
        return familyPrimes.size();
    }

    public ListOfLong getFamilyPrimes() {
        return familyPrimes.getUnModifiableListOfLong();
    }

    public static ReplaceFamily _null_(long canonicalSuspect) {
        return new ReplaceFamily(canonicalSuspect, new int[0], new ListOfLong());
    }

    public long getCanonicalSuspect() {
        return canonicalSuspect;
    }

    public int[] getReplaceIndexes() {
        return Arrays.copyOf(replaceIndexes, replaceIndexes.length);
    }
}
