package org.fde.projecteuler.problem_051;

class ReplaceFamily {
    private final long suspect;
    private final int first;
    private final int second;
    private final int family;

    public ReplaceFamily(long suspect, int first, int second, int family) {
        this.suspect = suspect;
        this.first = first;
        this.second = second;
        this.family = family;
    }

    @Override
    public String toString() {
        return "ReplaceFamily{" +
                "suspect=" + suspect +
                ", first=" + first +
                ", second=" + second +
                ", family=" + family +
                '}';
    }

    public int getFamily() {
        return family;
    }

    static ReplaceFamily _null_() {
        return new ReplaceFamily(0, 0, 0, 0);
    }
}
