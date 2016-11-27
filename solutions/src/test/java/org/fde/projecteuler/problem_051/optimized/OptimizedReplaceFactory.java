package org.fde.projecteuler.problem_051.optimized;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFactory;

public class OptimizedReplaceFactory implements ReplaceFactory {
    private final int targetFamily;

    public OptimizedReplaceFactory(int targetFamily) {
        this.targetFamily = targetFamily;
    }

    @Override
    public Replace createReplace(int[] replaceIndexes) {
        return new OptimizedReplace(replaceIndexes, targetFamily);
    }

    @Override
    public Replace _null_() {
        return OptimizedReplace.NULL;
    }
}
