package org.fde.util.combinations;

import java.util.*;

public class GenericCombination<T> implements Iterable<T> {
    private final List<T> list;

    public GenericCombination() {
        this.list = new ArrayList<>();
    }

    @SafeVarargs
    public GenericCombination(T... elements) {
        this.list = Arrays.asList(elements);
    }

    public GenericCombination(GenericCombination<T> other) {
        this.list = new ArrayList<>(other.list);
    }

    public void add(T element) {
        this.list.add(element);
    }

    public List<T> getList () {
        return Collections.unmodifiableList(this.list);
    }

    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public String toString() {
        return "GenericCombination{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericCombination<?> that = (GenericCombination<?>) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
