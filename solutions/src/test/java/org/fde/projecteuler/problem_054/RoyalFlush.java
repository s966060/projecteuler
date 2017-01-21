package org.fde.projecteuler.problem_054;

class RoyalFlush {
    private final Cards cards;

    private RoyalFlush(Cards cards) {
        this.cards = cards;
    }

    static RoyalFlush createRoyalFlush(Cards cards) {
        Cards orderedCards = cards.getFromHighToLow();
        return new RoyalFlush(orderedCards);
    }
}
