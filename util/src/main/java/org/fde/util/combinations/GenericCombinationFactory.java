package org.fde.util.combinations;

import java.util.List;

public class GenericCombinationFactory<T> {
    private final GenericCombinationList<T> list;
    private final List<T> elements;

    public GenericCombinationFactory(List<T> elements) {
        this.list = new GenericCombinationList<>();
        this.elements = elements;
    }

    public GenericCombinationList<T> getCombinations() {
        for (int size = 1; size <= getN(); ++size) {
            combine(new GenericCombination<>(), size, 0);
        }

        return list;
    }

    public GenericCombinationList<T> getCombinations(int sizeToRetain) {
        return getCombinations(sizeToRetain, sizeToRetain);
    }

    public GenericCombinationList<T> getCombinations(int beginSize, int endSize) {
        GenericCombinationList<T> list = getCombinations();

        GenericCombinationList<T> retained = new GenericCombinationList<>();

        list.forEach((c) -> {
            if (c.size() >= beginSize && c.size() <= endSize) {
                retained.add(c);
            }
        });

        return retained;
    }

    private int getMax(int size) {
        return elements.size() - size + 1;
    }

    private void combine(GenericCombination<T> input, int size, int index) {
        if (size == 0) {
            GenericCombination<T> gotcha = new GenericCombination<>(input);
            list.add(gotcha);
            return;
        }

        int max = getMax(size);

        for (; index < max; ++index) {
            GenericCombination<T> tryThisOne = new GenericCombination<>(input);
            tryThisOne.add(getElement(index));
            combine(tryThisOne, size - 1, index + 1);
        }
    }

    private T getElement(int index) {
        return elements.get(index);
    }

    private int getN() {
        return elements.size();
    }
}
