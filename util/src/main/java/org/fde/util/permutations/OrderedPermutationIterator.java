package org.fde.util.permutations;

import org.fde.util.ListOfLong;

import java.util.Iterator;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final ListOfLong input;

    public OrderedPermutationIterator(ListOfLong input) {
        this.input = input;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Permutation next() {
        return null;
    }
}
