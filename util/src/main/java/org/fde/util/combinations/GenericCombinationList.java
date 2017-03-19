package org.fde.util.combinations;

import java.util.*;
import java.util.function.Consumer;

public class GenericCombinationList<T>
        implements Iterable<GenericCombination<T>> {

    private final List<GenericCombination<T>> list;

    public GenericCombinationList() {
        this.list = new ArrayList<>();
    }

    public GenericCombinationList<T> add(GenericCombination<T> combination) {
        this.list.add(combination);
        return this;
    }

    GenericCombinationList<T> getUnique() {
        LinkedHashSet<GenericCombination> unique = new LinkedHashSet<>();

        unique.addAll(this.list);

        GenericCombinationList<T> uniqueList = new GenericCombinationList<>();

        unique.forEach(uniqueList::add);

        return uniqueList;
    }

    @Override
    public Iterator<GenericCombination<T>> iterator() {
        return this.list.iterator();
    }

    public int size() {
        return this.list.size();
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

        GenericCombinationList<T> that = (GenericCombinationList<T>) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
