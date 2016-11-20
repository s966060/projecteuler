package org.fde.util.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericCombination<T> {
    private final List<T> list;

    public GenericCombination() {
        this.list = new ArrayList<T>();
    }

    public GenericCombination(T... elements) {
        this.list = Arrays.asList(elements);
    }

    public GenericCombination(GenericCombination<T> other) {
        this.list = new ArrayList<T>(other.list);
    }

    public GenericCombination<T> add(T element) {
        this.list.add(element);
        return this;
    }

    public void add(GenericCombination<T> other) {
        for (T element : other.list) {
            add(element);
        }
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
