package org.fde.util.permutations;

import org.fde.util.ListOfLong;

public class OrderedPermutationFactory {
    private final ListOfLong input;
    private final PermutationList result;

    public OrderedPermutationFactory(ListOfLong input) {
        this.input = input;
        this.result = new PermutationList();
    }

    public PermutationList getPermutations() {
        makePermutations(new Permutation(), this.input);
        return this.result;
    }

    private void makePermutations(Permutation target, ListOfLong input) {
        if (input.size() == 0) {
            this.result.add(target);
        }

        for (int index = 0; index < input.size(); ++index) {
            ListOfLong next = new ListOfLong(input);
            Long first = next.get(index);
            next.removeAt(index);

            Permutation newPermutation = new Permutation(target).add(first);

            makePermutations(newPermutation, next);
        }
    }
}
