package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;

import java.util.Iterator;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final Context context;

    public OrderedPermutationIterator(ListOfLong input) {
        this.context = new Context(input);
    }

    @Override
    public boolean hasNext() {
        return this.context.hasNext();
    }

    @Override
    public Permutation next() {
        return this.context.next();
    }
}
