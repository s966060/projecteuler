package org.fde.util.permutations;

import org.fde.util.ListOfLong;

public class OrderedPermutationFactory {
    private final ListOfLong input;

    public OrderedPermutationFactory(ListOfLong input) {
        this.input = input;
    }

    public PermutationList getPermutations() {
        ListOfLong original = new ListOfLong(input);

        for(int index = 0; index < original.size(); ++index) {
            ListOfLong next = new ListOfLong(original);
            Long first = next.get(index);
            next.removeAt(index);
            next = new ListOfLong(first, next);
        }
        return null;
    }
}
