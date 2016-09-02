package org.fde.util.combinations;

import java.util.*;
import java.util.function.Consumer;

public class CombinationList implements Iterable<Combination> {
    private final List<Combination> list;

    public CombinationList() {
        this.list = new ArrayList<>();
    }

    public CombinationList add(Combination combination) {
        this.list.add(combination);
        return this;
    }

    public int size() {
        return this.list.size();
    }

    public CombinationList getUnique() {
        LinkedHashSet<Combination> unique = new LinkedHashSet<>();

        for (Combination c : this.list) {
            unique.add(c);
        }

        CombinationList uniqueList = new CombinationList();

        for (Combination c : unique) {
            uniqueList.add(c);
        }

        return uniqueList;
    }

    @Override
    public String toString() {
        return "CombinationList{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombinationList that = (CombinationList) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public Iterator<Combination> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super Combination> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<Combination> spliterator() {
        throw new UnsupportedOperationException();
    }
}
