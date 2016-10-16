package org.fde.util.permutations;

import org.fde.util.ListOfLong;

import java.util.Iterator;

public class PermutationIterator implements Iterator<Permutation> {
    private final ListOfLong initial;
    private Permutation current;
    private int index;

    public PermutationIterator(ListOfLong initial) {
        this.initial = initial;
        this.current = new Permutation(new ListOfLong(initial));
        this.index = 0;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Permutation next() {
        if (hasNext()) {
            Permutation toReturn = this.current;

            this.current = computeNext();
            return toReturn;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private Permutation computeNext() {
        if(initial.size() <= 1) {
            return null;
        }

        ListOfLong next = new ListOfLong(this.current.getList());

        if (index >= next.size() - 1) {
            index = 0;
        }

        next.swap(index, index + 1);
        ++index;

        if (next.equals(initial)) {
            return null;
        } else {
            return new Permutation(next);
        }
    }
}
