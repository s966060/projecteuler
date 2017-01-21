package org.fde.projecteuler.problem_054;

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
}
