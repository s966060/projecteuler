package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        Validate.inclusiveBetween(0, 5, this.cards.size());
        this.cards.add(card);
    }
}
