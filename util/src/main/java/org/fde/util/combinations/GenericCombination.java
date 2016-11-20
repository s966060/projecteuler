package org.fde.util.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GenericCombination<T> {
    private final List<T> list;

    GenericCombination() {
        this.list = new ArrayList<>();
    }

    @SafeVarargs
    GenericCombination(T... elements) {
        this.list = Arrays.asList(elements);
    }

    GenericCombination(GenericCombination<T> other) {
        this.list = new ArrayList<>(other.list);
    }

    public void add(T element) {
        this.list.add(element);
    }

    public List<T> getList () {
        return Collections.unmodifiableList(this.list);
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

    @Override
    public String toString() {
        return "GenericCombination{" +
                "list=" + list +
                '}';
    }
}
