package org.fde.projecteuler.problem_054;

class StraightFlush {
    private final Cards cards;

    private StraightFlush(Cards cards) {
        this.cards = cards;
    }

    static StraightFlush createStraightFlush(Cards cards) {
        Cards orderedCards = cards.getFromHighToLow();
        return new StraightFlush(orderedCards);
    }
}
