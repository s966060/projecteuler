package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class CardSuites {
    private final List<Cards> suites;

    public CardSuites() {
        this.suites = new ArrayList<Cards>();
    }

    public void add(Card card) {
        Validate.notNull(card);
        Cards cards = this.suites.get(card.suite.ordinal());
        cards.add(card);
    }
}
