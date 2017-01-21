package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Comparator;
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

    public Cards getFromHighToLow() {
        Cards cards = new Cards();
        cards.addAll(this);
        cards.sortFromHighToLow();
        return cards;
    }

    private void sortFromHighToLow() {
        this.cards.sort((o1, o2) -> {
            int compare = Integer.compare(
                                    o1.ranking.ordinal(),
                                    o2.ranking.ordinal());

            if (compare != 0) {
                return -compare;
            } else {
                compare = Integer.compare(
                                    o1.suite.ordinal(),
                                    o2.suite.ordinal());

                return compare;
            }
        });
    }

    public void addAll(Cards other) {
        this.cards.addAll(other.cards);
    }
}
