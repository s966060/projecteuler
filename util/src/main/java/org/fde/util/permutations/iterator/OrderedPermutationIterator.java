package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;

import java.util.Iterator;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final ContextList contextList;

    private OrderedPermutationIterator(ContextList contextList) {
        this.contextList = contextList;
    }

    public static OrderedPermutationIterator createOrderedPermutationIterator(
            ListOfLong input) {

        ContextList contextList;

        // special case on empty input
        // we must generate en empty permutation
        // 0! = 1 == one permutation of the set of empty elements
        if (input.isEmpty()) {
            contextList = new ContextList();
            contextList.add(new Context(input, 0));

        } else {
            contextList = new ContextList(input);
            return new OrderedPermutationIterator(contextList);
        }

        return new OrderedPermutationIterator(contextList);
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = !this.contextList.isEmpty();
        return hasNext;
    }

    @Override
    public Permutation next() {
        ListOfLong list = new ListOfLong();

        for (Context context : contextList) {
            // Only the empty set needs a hasValue() check !
            if (context.hasValue()) {
                Long value = context.getValue();
                list.add(value);
            }
        }

        Permutation permutation = new Permutation(list);
        createNext();

        return permutation;
    }

    private void createNext() {
        Context current;

        do {
            if (this.contextList.isEmpty()) {
                return;
            }

            current = this.contextList.removeLast();
            current.next();
        } while (!current.hasNext());

        this.contextList.create(current);
    }
}
