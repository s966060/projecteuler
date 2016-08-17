package org.fde.problem_012;

import java.util.List;

public class CombinationFactory {
    private final CombinationsList list;
    private final List<Long> input;

    public CombinationFactory(List<Long> input) {
        this.list = new CombinationsList();
        this.input = input;
    }

    public CombinationsList getCombinations() {
        for (int size = 1; size <= getN(); ++size) {
            combine(size);
        }

        return list;
    }

    private void combine(int size) {
        int max = input.size() - size + 1;

        for(int index = 0; index < max; ++index) {
            Combination combination = new Combination(getElement(index));
            combine(combination, size - 1, index + 1);
        }
    }

    private void combine(Combination combination, int size, int index) {
        if(size == 0) {
            Combination gotcha = new Combination(combination);
            list.add(gotcha);
            return;
        }

        int max = input.size() - size + 1;

        for(; index < max; ++index) {
            Combination tryThisOne = new Combination(combination);
            tryThisOne.add(getElement(index));
            combine(tryThisOne, size - 1, index + 1);
        }
    }

    private Long getElement(int index) {
        return input.get(index);
    }

    private int getN() {
        return input.size();
    }
}
