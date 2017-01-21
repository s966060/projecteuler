package org.fde.projecteuler.problem_054;

class Flush {
    private final Cards cards;

    private Flush(Cards cards) {
        this.cards = cards;
    }

    static Flush createFlush(Cards cards) {
        Cards orderedCards = cards.getFromHighToLow();
        return new Flush(orderedCards);
    }
}
