package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

import static org.fde.projecteuler.problem_054.Ranking.*;

class CardRankings {
    private List<Cards> rankings;

    CardRankings() {
        this.rankings = new ArrayList<>();

        for (Ranking ranking : values()) {
            this.rankings.add(new Cards());
        }
    }

    public void add(Card card) {
        Validate.notNull(card);

        Cards cards = this.rankings.get(card.ranking.ordinal());
        Validate.notNull(cards);

        cards.add(card);
    }

    Card getHighCard() {
        Card highCard = null;

        for (Cards cards : rankings) {
            if (cards.hasCards()) {
                highCard = cards.getFirstCard();
            }
        }

        return highCard;
    }

    boolean hasTenJackQueenKingAce() {
        return has(ACE)
                && has(KING)
                && has(QUEEN)
                && has(JACK)
                && has(TEN);
    }

    private boolean has(Ranking ranking) {
        return !rankings.get(ranking.ordinal()).isEmpty();
    }

    boolean has5ConsecutiveValues() {
        Ranking[] search = {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN};

        nextRanking:
        for (Ranking ranking : search) {
            for (Ranking suspect : ranking.getThisAndNextFour()) {
                if (!has(suspect)) {
                    continue nextRanking;
                }
            }

            return true;
        }

        return false;
    }
}
