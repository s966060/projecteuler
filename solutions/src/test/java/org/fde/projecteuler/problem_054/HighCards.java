package org.fde.projecteuler.problem_054;

class HighCards {
    private final Cards cards;

    private HighCards(Cards cards) {
        this.cards = cards;
    }

    static HighCards createHighCards(Cards cards) {
        return new HighCards(cards.getFromHighToLow());
    }

    @Override
    public String toString() {
        return "HighCards{" +
                "cards=" + cards +
                '}';
    }
}
