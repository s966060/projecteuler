package org.fde.projecteuler.problem_051;

import java.util.Arrays;

class Replace {
    public static final Replace NULL = new Replace(new int[0]);

    private final int[] iterators;

    public Replace(int[] iterators) {
        this.iterators = Arrays.copyOf(iterators, iterators.length);
    }
}
