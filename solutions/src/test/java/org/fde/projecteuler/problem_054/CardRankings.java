package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

class CardRankings {
    private List<Cards> rankings;

    CardRankings() {
        this.rankings = new ArrayList<>();

        for (Ranking ranking : Ranking.values()) {
            this.rankings.add(new Cards());
        }
    }

    public void add(Card card) {
        Validate.notNull(card);

        Cards cards = this.rankings.get(card.ranking.ordinal());
        Validate.notNull(cards);

        cards.add(card);
    }
}
