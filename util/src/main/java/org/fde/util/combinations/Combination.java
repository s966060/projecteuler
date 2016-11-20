package org.fde.util.combinations;

public class Combination {
    private final GenericCombination<Long> internal;

    Combination(Long... elements) {
        this.internal = new GenericCombination<>(elements);
    }

    Combination(GenericCombination<Long> other) {
        this.internal = other;
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
