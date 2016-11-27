package org.fde.projecteuler.problem_051;

import java.util.Arrays;

class ReplaceFamily {
    private final long canonicalSuspect;
    private final int[] replaceIndexes;
    private final int family;

    public ReplaceFamily(long canonicalSuspect, int[] replaceIndexes, int family) {
        this.canonicalSuspect = canonicalSuspect;
        this.replaceIndexes = replaceIndexes;
        this.family = family;
    }

    @Override
    public String toString() {
        return "ReplaceFamily{" +
                "canonicalSuspect=" + canonicalSuspect +
                ", replaceIndexes=" + Arrays.toString(replaceIndexes) +
                ", family=" + family +
                '}';
    }

    public int getFamily() {
        return family;
    }

    static ReplaceFamily _null_(long canonicalSuspect) {
        return new ReplaceFamily(canonicalSuspect, new int[0], 0);
    }
}
