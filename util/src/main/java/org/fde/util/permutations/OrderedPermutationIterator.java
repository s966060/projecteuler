package org.fde.util.permutations;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final ListOfLong input;
    private final List<Context> context;

    class Context {
        int index;
        ListOfLong input;

        public Context(int index, ListOfLong input) {
            this.index = index;
            this.input = input;
        }
    }

    class ContextListFactory {
        private final List<Context> context;

        public ContextListFactory() {
            this.context = new ArrayList<>();
        }

        public List<Context> create(ListOfLong input) {
            if (input.size() == 0) {
                return this.context;
            }

            this.context.add(new Context(0, new ListOfLong(input)));

            ListOfLong next = new ListOfLong(input);
            next.removeAt(0);

            create(next);

            return this.context;
        }
    }

    public OrderedPermutationIterator(ListOfLong input) {
        this.input = input;

        this.context = new ContextListFactory().create(this.input);
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
