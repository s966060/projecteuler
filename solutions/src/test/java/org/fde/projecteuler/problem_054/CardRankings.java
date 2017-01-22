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

    void add(Hand hand) {
        Validate.isTrue(hand.isValid());

        for (Card card : hand) {
            add(card);
        }
    }

    private void add(Card card) {
        Validate.notNull(card);

        Cards cards = this.rankings.get(card.ranking.ordinal());
        Validate.notNull(cards);

        cards.add(card);
    }

    boolean hasTenJackQueenKingAce() {
        return has5ConsecutiveValues(TEN);
    }

    private boolean has(Ranking ranking) {
        return !rankings.get(ranking.ordinal()).isEmpty();
    }

    boolean has5ConsecutiveValues() {
        Ranking[] search = {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN};

        for (Ranking ranking : search) {
            if (has5ConsecutiveValues(ranking)) {
                return true;
            }
        }

        return false;
    }

    private boolean has5ConsecutiveValues(Ranking ranking) {
        for (Ranking suspect : ranking.getThisAndNextFour()) {
            if (!has(suspect)) {
                return false;
            }
        }

        return true;
    }

    boolean hasFourOfAKind() {
        Cards cards = getFourOfAKindCards();

        return cards != null;
    }

    Cards getFourOfAKindCards() {
        for (Ranking ranking : Ranking.values()) {
            Cards cards = get(ranking);

            if (cards.hasFour()) {
                return cards;
            }
        }

        return null;
    }

    private Cards get(Ranking ranking) {
        return this.rankings.get(ranking.ordinal());
    }

    Cards getAllCards() {
        Cards cards = new Cards();

        for (Ranking ranking : Ranking.values()) {
            Cards otherCards = get(ranking);
            cards.addAll(otherCards);
        }

        return cards;
    }

    boolean hasFullHouse() {
        Cards two = null;
        Cards three = null;

        for (Ranking ranking : Ranking.values()) {
            Cards cards = get(ranking);

            if (cards.hasTwo()) {
                two = cards;
            }

            if (cards.hasThree()) {
                three = cards;
            }
        }

        return two != null && three != null;
    }

    boolean hasThreeOfAKind() {
        Cards three = null;

        for (Ranking ranking : Ranking.values()) {
            Cards cards = get(ranking);

            if (cards.hasThree()) {
                three = cards;
            }
        }

        return three != null;
    }

    boolean hasTwoPairs() {
        Cards firstPair = null;
        Cards secondPair = null;

        for (Ranking ranking : Ranking.values()) {
            Cards cards = get(ranking);

            if (cards.hasTwo()) {
                if (firstPair == null) {
                    firstPair = cards;
                } else if (secondPair == null) {
                    secondPair = cards;
                }
            }
        }

        return firstPair != null && secondPair != null;
    }

    boolean hasOnePair() {
        Cards two = null;

        for (Ranking ranking : Ranking.values()) {
            Cards cards = get(ranking);

            if (cards.hasTwo()) {
                two = cards;
            }
        }

        return two != null;
    }
}
