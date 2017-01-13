package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

class Hand {
    private final List<Card> cards;

    Hand() {
        this.cards = new ArrayList<>();
    }

    void add(Card card) {
        Validate.inclusiveBetween(0, 5, this.cards.size());
        this.cards.add(card);
    }

    boolean isValid() {
        return this.cards.size() == 5;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }

    public HandEvaluation getEvaluation() {
        HandEvaluation eval = HandEvaluation.evaluate(this);
    }
}
