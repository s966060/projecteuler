package org.fde.util.permutations;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderedPermutationIterator implements Iterator<Permutation> {
    private final ListOfLong input;
    private final ContextList context;

    class Context {
        Permutation current;
        int index;
        ListOfLong input;

        public Context(Permutation current, int index, ListOfLong input) {
            this.current = current;
            this.index = index;
            this.input = input;
        }
    }

    class ContextList {
        private List<Context> context;

        ContextList() {
            this.context = new ArrayList<>();
        }

        void add(Context ctx) {
            this.context.add(ctx);
        }

        Context getLast() {
            return this.context.get(size() - 1);
        }

        boolean hasLast() {
            return !this.context.isEmpty();
        }

        public int size() {
            return this.context.size();
        }
    }

    class ContextListFactory {
        private final ContextList context;

        public ContextListFactory() {
            this.context = new ContextList();
        }

        public ContextList create(ListOfLong input) {
            if (input.size() == 0) {
                return this.context;
            }

            Permutation newPermutation;

            if (context.hasLast()) {
                newPermutation = new Permutation(context.getLast().current);
            } else {
                newPermutation = new Permutation();
            }

            this.context.add(new Context(newPermutation, 0, new ListOfLong(input)));

            ListOfLong next = new ListOfLong(input);

            newPermutation.add(next.get(0));
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
        return this.context.size() == this.input.size();
    }

    @Override
    public Permutation next() {
        return null;
    }
}
