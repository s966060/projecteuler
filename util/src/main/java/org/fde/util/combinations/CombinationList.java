package org.fde.util.combinations;

import java.util.Iterator;
import java.util.function.Consumer;

public class CombinationList implements Iterable<Combination> {
    private final GenericCombinationList<Long> internal;

    public CombinationList() {
        this.internal = new GenericCombinationList<>();
    }

    CombinationList(GenericCombinationList<Long> other) {
        this.internal = other;
    }

    public CombinationList add(Combination combination) {
        this.internal.add(combination.getInternal());
        return this;
    }

    public int size() {
        return internal.size();
    }

    public CombinationList getUnique() {
        return new CombinationList(this.internal.getUnique());
    }


    @Override
    public Iterator<Combination> iterator() {
        final Iterator<GenericCombination<Long>> it = this.internal.iterator();

        return new Iterator<Combination>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Combination next() {
                return new Combination(it.next());
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Combination> action) {

    }

    @Override
    public String toString() {
        return "CombinationList{" +
                "internal=" + internal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombinationList that = (CombinationList) o;

        return internal.equals(that.internal);

    }

    @Override
    public int hashCode() {
        return internal.hashCode();
    }
}
