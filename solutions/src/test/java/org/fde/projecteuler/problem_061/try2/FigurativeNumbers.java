package org.fde.projecteuler.problem_061.try2;

import org.fde.projecteuler.problem_061.try2.figurative_numbers.FigurativeNumber;
import org.fde.util.ListOfLong;

class FigurativeNumbers {
    private final PrefixContainer prefix;
    private final PostfixContainer postfix;
    private final ListOfLong numbers;

    FigurativeNumbers(ListOfLong numbers,
                      PrefixContainer prefix,
                      PostfixContainer postfix) {

        this.numbers = numbers;
        this.prefix = prefix;
        this.postfix = postfix;
    }

    ListOfLong getLinkedOnPrefix(long value) {
        ListOfLong onPostFixValue = this.prefix.getOnPostFixValue(value);
        return onPostFixValue;
    }

    static FigurativeNumbers createFigurativeNumbers(
            FigurativeNumber figurativeNumber) {

        ListOfLong numbers = new ListOfLong();
        PrefixContainer prefix = new PrefixContainer();
        PostfixContainer postfix = new PostfixContainer();

        long value = 0;
        int n = 0;

        while (value < 10_000) {
            value = figurativeNumber.compute(n);

            if (value >= 1_000 && value < 10_000) {
                numbers.add(value);
                prefix.add(value);
                postfix.add(value);
            }

            ++n;
        }

        return new FigurativeNumbers(numbers, prefix, postfix);
    }

    public ListOfLong getNumbers() {
        return numbers;
    }
}
