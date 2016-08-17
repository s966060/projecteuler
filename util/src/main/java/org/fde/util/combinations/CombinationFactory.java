package org.fde.util.combinations;

import java.util.List;

public class CombinationFactory {
    private final CombinationsList list;
    private final List<Long> elements;

    public CombinationFactory(List<Long> elements) {
        this.list = new CombinationsList();
        this.elements = elements;
    }

    public CombinationsList getCombinations() {
        for (int size = 1; size <= getN(); ++size) {
            combine(new Combination(), size, 0);
        }

        return list;
    }

    private int getMax(int size) {
        return elements.size() - size + 1;
    }

    private void combine(Combination input, int size, int index) {
        if (size == 0) {
            Combination gotcha = new Combination(input);
            list.add(gotcha);
            return;
        }

        int max = getMax(size);

        for (; index < max; ++index) {
            Combination tryThisOne = new Combination(input);
            tryThisOne.add(getElement(index));
            combine(tryThisOne, size - 1, index + 1);
        }
    }

    private Long getElement(int index) {
        return elements.get(index);
    }

    private int getN() {
        return elements.size();
    }
}
