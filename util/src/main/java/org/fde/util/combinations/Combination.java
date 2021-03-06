package org.fde.util.combinations;

import org.fde.util.ListOfLong;

import java.util.Iterator;

public class Combination implements Iterable<Long> {
    private final GenericCombination<Long> internal;

    public Combination(Long... elements) {
        this.internal = new GenericCombination<>(elements);
    }

    public Combination(GenericCombination<Long> other) {
        this.internal = other;
    }

    public Combination(Combination other) {
        this.internal = new GenericCombination<>(other.getInternal());
    }

    public Long get(int index) {
        return this.internal.get(index);
    }

    public void add(Long value) {
        this.internal.add(value);
    }

    public long product() {
        if (internal.getList().isEmpty()) {
            return 0;
        } else {
            long result = 1;

            for (Long number : this.internal) {
                result *= number;
            }

            return result;
        }
    }

    public long sum() {
        long result = 0;

        for (Long value : internal) {
            result += value;
        }

        return result;
    }

    GenericCombination<Long> getInternal() {
        return internal;
    }

    public ListOfLong getAsList() {
        ListOfLong list = new ListOfLong();

        for (Long value : this) {
            list.add(value);
        }

        return list;
    }

    public Long getLast() {
        return this.internal.getLast();
    }

    @Override
    public Iterator<Long> iterator() {
        return this.internal.iterator();
    }

    @Override
    public String toString() {
        return "Combination{" +
                "internal=" + internal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination that = (Combination) o;

        return internal.equals(that.internal);

    }

    @Override
    public int hashCode() {
        return internal.hashCode();
    }
}
