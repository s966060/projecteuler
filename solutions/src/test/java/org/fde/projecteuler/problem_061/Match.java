package org.fde.projecteuler.problem_061;

class Match {
    private final FinderContext match;

    Match(FinderContext match) {
        this.match = match;
    }

    long getSum() {
        long sum = 0;

        for(Long value : this.match.getValues()) {
            sum += value;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Match{" +
                "match=" + match +
                '}';
    }
}
