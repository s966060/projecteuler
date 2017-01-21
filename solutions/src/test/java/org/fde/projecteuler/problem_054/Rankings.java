package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

class Rankings {
    private List<Cards> rankings;

    Rankings() {
        this.rankings = new ArrayList<>();
        this.rankings.add(null);

        for (Ranking ranking : Ranking.values()) {
            this.rankings.add(new Cards());
        }
    }

    public void add(Card card) {
        Validate.notNull(card);

        Cards cards = this.rankings.get(card.ranking.getValue());
        Validate.notNull(cards);

        cards.add(card);
    }
}
