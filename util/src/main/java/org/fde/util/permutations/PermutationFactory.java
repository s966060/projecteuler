package org.fde.util.permutations;

import java.util.List;

public class PermutationFactory {
    private final List<Long> elements;

    public PermutationFactory(List<Long> elements) {
        this.elements = elements;
    }

    public PermutationList getPermutations() {
        PermutationList result = makePermutation(new PermutationList(), 1);

        return result;
    }

    private PermutationList makePermutation(PermutationList start, int size) {
        if (size <= getN()) {
            int index = size - 1;

            Long el = elements.get(index);

            PermutationList newPermutations = new PermutationList();

            if (start.isEmpty()) {
                newPermutations.add(new Permutation(el));
            } else {
                for (Permutation p : start) {
                    PermutationList list = p.createNewPermutations(el);
                    newPermutations.add(list);
                }
            }

            return makePermutation(newPermutations, size + 1);
        } else {
            return start;
        }
    }

    private int getN() {
        return elements.size();
    }
}
