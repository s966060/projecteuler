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
            Combination combination = new Combination(input.get(index));
            Combination other = combine(size - 1, index + 1);

            combination.add(other);
            list.add(combination);
        }
    }

    private Combination combine(int size, int index) {
        Combination combination = new Combination();

        if(size == 0) {
            return combination;
        }

        int max = input.size() - size + 1;

        for(; index < max; ++index) {
            combination.add(input.get(index));
        }

        return combination;
    }

    private int getN() {
        return input.size();
    }
}
