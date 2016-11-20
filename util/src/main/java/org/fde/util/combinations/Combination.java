package org.fde.util.combinations;

import org.fde.util.ListOfLong;

public class Combination {
    private final GenericCombination<Long> internal;

    public Combination(Long... elements) {
        this.internal = new GenericCombination<>(elements);
    }

    Combination(GenericCombination<Long> other) {
        this.internal = other;
    }

    public Combination add(Long element) {
        this.internal.add(element);
        return this;
    }

    public void add(Combination other) {
        other.internal.getList().forEach(this::add);
    }

    public long multiply() {
        if (internal.getList().isEmpty()) {
            return 0;
        } else {
            long result = 1;

            for (Long number : this.internal.getList()) {
                result *= number;
            }

            return result;
        }
    }

    public ListOfLong getList () {
        return new ListOfLong(this.internal.getList());
    }

    GenericCombination<Long> getInternal() {
        return internal;
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
