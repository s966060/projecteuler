package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

class CardSuites {
    private final List<Cards> suites;

    CardSuites() {
        this.suites = new ArrayList<Cards>();
    }

    void add(Card card) {
        Validate.notNull(card);
        Cards cards = this.suites.get(card.suite.ordinal());
        cards.add(card);
    }

    boolean hasFlush() {
        for(Cards cards : suites) {
            if(cards.hasFive()) {
                return true;
            }
        }

        return false;
    }
}
