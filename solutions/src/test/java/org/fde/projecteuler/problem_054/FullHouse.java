package org.fde.projecteuler.problem_054;

class FullHouse {
    private final Cards cards;

    private FullHouse(Cards cards) {
        this.cards = cards;
    }

    static FullHouse createFullHouse(Cards cards) {
        return new FullHouse(cards.getFromHighToLow());
    }

    @Override
    public String toString() {
        return "FullHouse{" +
                "cards=" + cards +
                '}';
    }
}
