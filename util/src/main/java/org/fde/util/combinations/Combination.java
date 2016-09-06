package org.fde.util.combinations;

import org.fde.util.ListOfLong;

public class Combination {
    private final ListOfLong list;

    public Combination() {
        this.list = new ListOfLong();
    }

    public Combination(Long... elements) {
        this.list = new ListOfLong(elements);
    }

    public Combination(Combination other) {
        this.list = new ListOfLong(other.list);
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
