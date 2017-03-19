package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;

import java.util.Iterator;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final ContextList contextList;

    public OrderedPermutationIterator(ListOfLong input) {
        this.contextList = new ContextList(input);
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = this.contextList.getFirst().hasNext();
        return hasNext;
    }

    @Override
    public Permutation next() {
        ListOfLong list = new ListOfLong();

        for(Context context : contextList) {
            Long value = context.getValue();
            list.add(value);
        }

        Permutation permutation = new Permutation(list);
        createNext();

        return permutation;
    }

    private void createNext() {
        this.contextList.getFirst().index++;
    }
}
