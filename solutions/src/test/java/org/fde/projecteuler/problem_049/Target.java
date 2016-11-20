package org.fde.projecteuler.problem_049;

class Target implements Comparable<Target> {
    private final long prime;
    private final long canonical;

    Target(long prime, long canonical) {
        this.prime = prime;
        this.canonical = canonical;
    }

    long getCanonical() {
        return canonical;
    }

    long getPrime() {
        return prime;
    }

    @Override
    public String toString() {
        return "Target{" +
                "prime=" + prime +
                ", canonical=" + canonical +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Target target = (Target) o;

        if (prime != target.prime) return false;
        return canonical == target.canonical;

    }

    @Override
    public int hashCode() {
        int result = (int) (prime ^ (prime >>> 32));
        result = 31 * result + (int) (canonical ^ (canonical >>> 32));
        return result;
    }

    @Override
    public int compareTo(Target other) {
        int compare = compareCanonical(other);

        if (compare != 0) {
            return compare;
        } else {
            return comparePrime(other);
        }
    }

    private int comparePrime(Target other) {
        return Long.compare(this.prime, other.prime);
    }

    int compareCanonical(Target other) {
        return Long.compare(this.canonical, other.canonical);
    }
}
