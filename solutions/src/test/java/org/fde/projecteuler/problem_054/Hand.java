package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.Iterator;

class Hand implements Iterable<Card> {
    private final Cards cards;

    Hand() {
        this.cards = new Cards();
    }

    void add(Card card) {
        Validate.inclusiveBetween(0, 5, this.cards.size());
        this.cards.add(card);
    }

    boolean isValid() {
        return this.cards.size() == 5;
    }

    HandEvaluation getEvaluation() {
        HandEvaluation eval = new HandEvaluation().evaluate(this);
        return eval;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
