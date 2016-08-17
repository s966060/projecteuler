package org.fde.util.combinations;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CombinationList {
    private final List<Combination> list;

    public CombinationList() {
        this.list = new ArrayList<>();
    }

    public CombinationList add(Combination combination) {
        this.list.add(combination);
        return this;
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
    public String toString() {
        return "CombinationList{" +
                "list=" + list +
                '}';
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
}
