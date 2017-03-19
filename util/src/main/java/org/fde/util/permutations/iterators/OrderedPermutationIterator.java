package org.fde.util.permutations.iterators;

import org.fde.util.ListOfLong;

public class OrderedPermutationIterator {
    private final Context context;

    public OrderedPermutationIterator(ListOfLong input) {
        this.context = new Context(input);
    }

}
