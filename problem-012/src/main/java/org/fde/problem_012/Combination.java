package org.fde.problem_012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    private final List<Long> combination;

    public Combination() {
        this.combination = new ArrayList<>();
    }

    public Combination(Long... args) {
        this();
        this.combination.addAll(Arrays.asList(args));
    }

    public Combination add(Long element) {
        this.combination.add(element);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination that = (Combination) o;

        return combination.equals(that.combination);

    }

    @Override
    public int hashCode() {
        return combination.hashCode();
    }

    @Override
    public String toString() {
        return "Combination{" +
                "combination=" + combination +
                '}';
    }
}
