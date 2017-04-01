package org.fde.projecteuler.problem_061;

import org.fde.projecteuler.problem_061.figurative_numbers.FigurativeNumber;
import org.fde.util.ListOfLong;

class FigurativeNumbers {
    private final FigurativeNumber figurativeNumber;
    private final PrefixContainer prefix;
    private final ListOfLong numbers;

    FigurativeNumbers(FigurativeNumber figurativeNumber,
                      ListOfLong numbers,
                      PrefixContainer prefix) {

        this.figurativeNumber = figurativeNumber;
        this.numbers = numbers;
        this.prefix = prefix;
    }

    // Example
    // value = 1234
    // possible postfix values (2222, 3333, 3400, 3444, 3500)
    // match value = 34
    // --> 3400, 3444
    ListOfLong getLinkedOnPrefix(long value) {
        ListOfLong onPostFixValue = this.prefix.getOnPostFixValue(value);
        return onPostFixValue;
    }

    public boolean isLinkedOnPrefix(long value, long linkValue) {
        ListOfLong suspects = getLinkedOnPrefix(value);

        boolean isLinked = suspects.contains(linkValue);
        return isLinked;
    }

    static FigurativeNumbers createFigurativeNumbers(
            FigurativeNumber figurativeNumber) {

        ListOfLong numbers = new ListOfLong();
        PrefixContainer prefix = new PrefixContainer();

        long value = 0;
        int n = 0;

        while (value < 10_000) {
            value = figurativeNumber.compute(n);

            if (value >= 1_000 && value < 10_000) {
                numbers.add(value);
                prefix.add(value);
            }

            ++n;
        }

        return new FigurativeNumbers(figurativeNumber, numbers, prefix);
    }

    ListOfLong getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "FigurativeNumbers{" +
                "figurativeNumber=" + figurativeNumber +
                '}';
    }
}
