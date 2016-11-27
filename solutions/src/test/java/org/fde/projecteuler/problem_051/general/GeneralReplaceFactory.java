package org.fde.projecteuler.problem_051.general;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFactory;

public class GeneralReplaceFactory implements ReplaceFactory {
    @Override
    public Replace createReplace(int[] replaceIndexes) {
        return new GeneralReplace(replaceIndexes);
    }

    @Override
    public Replace _null_() {
        return GeneralReplace.NULL;
    }
}
