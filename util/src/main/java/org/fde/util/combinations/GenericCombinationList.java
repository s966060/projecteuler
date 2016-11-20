package org.fde.util.combinations;

import java.util.*;
import java.util.function.Consumer;

public class GenericCombinationList<T>
        implements Iterable<GenericCombination<T>> {

    private final List<GenericCombination<T>> list;

    public GenericCombinationList() {
        this.list = new ArrayList<>();
    }

    public GenericCombinationList add(GenericCombination combination) {
        this.list.add(combination);
        return this;
    }

    public GenericCombinationList getUnique() {
        LinkedHashSet<GenericCombination> unique = new LinkedHashSet<>();

        unique.addAll(this.list);

        GenericCombinationList uniqueList = new GenericCombinationList();

        unique.forEach(uniqueList::add);

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

        GenericCombinationList that = (GenericCombinationList) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public Iterator<GenericCombination<T>> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super GenericCombination<T>> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<GenericCombination<T>> spliterator() {
        throw new UnsupportedOperationException();
    }
}
