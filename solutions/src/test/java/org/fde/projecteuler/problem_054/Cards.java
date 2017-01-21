package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int size() {
        return this.cards.size();
    }

    public Iterator<Card> iterator() {
        return this.cards.iterator();
    }

    public boolean hasFive() {
        return this.cards.size() == 5;
    }

    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public Card getFirstCard() {
        Validate.isTrue(hasCards());
        return cards.get(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
