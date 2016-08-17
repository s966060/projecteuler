package org.fde.problem_012;

import java.util.ArrayList;
import java.util.List;

public class CombinationsList {
    private final List<Combination> list;

    public CombinationsList() {
        this.list = new ArrayList<>();
    }

    public CombinationsList add(Combination combination) {
        this.list.add(combination);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombinationsList that = (CombinationsList) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public String toString() {
        return "CombinationsList{" +
                "list=" + list +
                '}';
    }
}
