package org.fde.projecteuler.problem_054;

class FourOfAKind {
    private final Cards cards;

    private FourOfAKind(Cards cards) {
        this.cards = cards;
    }

    static FourOfAKind createFourOfAKind(Cards cards) {
        return new FourOfAKind(cards.getFromHighToLow());
    }

    @Override
    public String toString() {
        return "FourOfAKind{" +
                "cards=" + cards +
                '}';
    }
}
