package org.fde.util.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private final List<Long> list;

    public Permutation() {
        this.list = new ArrayList<>();
    }

    public Permutation(long... elements) {
        this();

        for (long el : elements) {
            add(el);
        }
    }

    private Permutation(List<Long> list) {
        this.list = list;
    }

    public void add(long el) {
        this.list.add(el);
    }

    @Override
    public String toString() {
        return "Permutation{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permutation that = (Permutation) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    public PermutationList createNewPermutations(Long el) {
        PermutationList newPermutations = new PermutationList();

        // the backwards loops is just for the output order
        // nothing special
        for (int index = list.size(); index >= 0; --index) {
            List<Long> newList = new ArrayList<>(this.list);

            newList.add(index, el);

            newPermutations.add(new Permutation(newList));
        }

        return newPermutations;
    }
}
