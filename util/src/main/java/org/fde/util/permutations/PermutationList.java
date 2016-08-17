package org.fde.util.permutations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PermutationList implements Iterable<Permutation> {
    private final List<Permutation> list;

    public PermutationList() {
        this.list = new ArrayList<>();
    }

    public PermutationList add(Permutation p) {
        this.list.add(p);
        return this;
    }

    public void add(PermutationList other) {
        this.list.addAll(other.list);
    }

    @Override
    public String toString() {
        return "PermutationList{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermutationList that = (PermutationList) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<Permutation> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super Permutation> action) {
        list.forEach(action);
    }

    @Override
    public Spliterator<Permutation> spliterator() {
        throw new UnsupportedOperationException();
    }
}
