package org.fde.projecteuler.problem_054;

class ThreeOfAKind {
    private final Cards cards;

    private ThreeOfAKind(Cards cards) {
        this.cards = cards;
    }

    static ThreeOfAKind createThreeOfAKind(Cards cards) {
        return new ThreeOfAKind(cards);
    }
}
