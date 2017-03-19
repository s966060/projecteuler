package org.fde.util.permutations;

import org.fde.util.ListOfLong;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Permutation implements Iterable<Long> {
    private final ListOfLong list;

    public Permutation() {
        this.list = new ListOfLong();
    }

    public Permutation(Permutation other) {
        this.list = new ListOfLong(other.list);
    }

    public Permutation(ListOfLong list) {
        this.list = list;
    }

    public static Permutation createPermutation(long... elements) {
        Permutation p = new Permutation();

        for (long el : elements) {
            p.add(el);
        }

        return p;
    }

    public Permutation add(long el) {
        this.list.add(el);
        return this;
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

    @Override
    public Iterator<Long> iterator() {
        return list.getUnModifiableListOfLong().iterator();
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        list.getUnModifiableListOfLong().forEach(action);
    }

    @Override
    public Spliterator<Long> spliterator() {
        throw new UnsupportedOperationException();
    }

    public ListOfLong getList() {
        return list.getUnModifiableListOfLong();
    }
}
