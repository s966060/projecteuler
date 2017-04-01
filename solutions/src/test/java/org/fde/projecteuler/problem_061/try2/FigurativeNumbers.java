package org.fde.projecteuler.problem_061.try2;

import org.fde.projecteuler.problem_061.FigurativeNumber;

class FigurativeNumbers {
    private final PrefixContainer prefix;
    private final PostfixContainer postfix;

    FigurativeNumbers(PrefixContainer prefix, PostfixContainer postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public static FigurativeNumbers createFigurativeNumbers(
            FigurativeNumber figurativeNumber) {

        PrefixContainer prefix = new PrefixContainer();
        PostfixContainer postfix = new PostfixContainer();

        long value = 0;
        int n = 0;

        while (value < 10_000) {
            value = figurativeNumber.compute(n);

            if (value >= 1_000 && value < 10_000) {
                prefix.add(value);
                postfix.add(value);
            }

            ++n;
        }

        return new FigurativeNumbers(prefix, postfix);
    }
}
