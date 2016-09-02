package org.fde.util.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    private final List<Long> list;

    public Combination() {
        this.list = new ArrayList<>();
    }

    public Combination(Long... elements) {
        this();
        this.list.addAll(Arrays.asList(elements));
    }

    public Combination(Combination other) {
        this.list = new ArrayList<>(other.list);
    }

    public Combination add(Long element) {
        this.list.add(element);
        return this;
    }

    public void add(Combination other) {
        for (Long element : other.list) {
            add(element);
        }
    }

    public long multiply() {
        if (list.isEmpty()) {
            return 0;
        } else {
            long result = 1;

            for (Long number : this.list) {
                result *= number;
            }

            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination that = (Combination) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public String toString() {
        return "Combination{" +
                "list=" + list +
                '}';
    }
}
