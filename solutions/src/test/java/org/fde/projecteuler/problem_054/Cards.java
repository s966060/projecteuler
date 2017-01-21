package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cards {
    private final List<Card> cards;

    Cards() {
        this.cards = new ArrayList<>();
    }

    void add(Card card) {
        this.cards.add(card);
    }

    int size() {
        return this.cards.size();
    }

    Iterator<Card> iterator() {
        return this.cards.iterator();
    }

    boolean hasFive() {
        return size() == 5;
    }

    boolean hasCards() {
        return !cards.isEmpty();
    }

    Card getFirstCard() {
        Validate.isTrue(hasCards());
        return cards.get(0);
    }

    boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean hasFour() {
        return size() == 4;
    }
}
