package org.fde.projecteuler.problem_031;

class Participant {
    private final long coin;
    private final long count;

    public Participant(long coin, long count) {
        this.coin = coin;
        this.count = count;
    }

    public long getAmount() {
        return coin * count;
    }

    public boolean isSameCoin(Participant other) {
        return this.coin == other.coin;
    }

    @Override
    public String toString() {
        return String.format("Participant{%sc * %s}", coin, count);
    }
}
