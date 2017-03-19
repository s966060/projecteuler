package org.fde.util.permutations.factory;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;

public class PermutationFactory {
    private final ListOfLong elements;

    public PermutationFactory(ListOfLong elements) {
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
                newPermutations.add(new Permutation().add(el));
            } else {
                for (Permutation p : start) {
                    PermutationList list = createNewPermutations(p, el);
                    newPermutations.add(list);
                }
            }

            return makePermutation(newPermutations, size + 1);
        } else {
            return start;
        }
    }

    private PermutationList createNewPermutations(Permutation p, Long el) {
        PermutationList newPermutations = new PermutationList();

        ListOfLong list = p.getList();

        // the backwards loops is just for the output order
        // nothing special
        for (int index = list.size(); index >= 0; --index) {
            ListOfLong newList = new ListOfLong(list);

            newList.add(index, el);

            newPermutations.add(new Permutation(newList));
        }

        return newPermutations;
    }

    private int getN() {
        return elements.size();
    }
}
