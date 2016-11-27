package org.fde.projecteuler.problem_051.optimized;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFactory;

public class OptimizedReplaceFactory implements ReplaceFactory {
    @Override
    public Replace createReplace(int[] replaceIndexes) {
        return new OptimizedReplace(replaceIndexes);
    }

    @Override
    public Replace _null_() {
        return OptimizedReplace.NULL;
    }
}
