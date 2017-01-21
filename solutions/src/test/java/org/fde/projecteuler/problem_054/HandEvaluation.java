package org.fde.projecteuler.problem_054;

class HandEvaluation {
    private final CardRankings rankings = new CardRankings();
    private final CardSuites suites = new CardSuites();

    HandEvaluation evaluate(Hand hand) {
        for (Card card : hand) {
            rankings.add(card);
            suites.add(card);
        }

        if (suites.hasFlush()) {
            if (rankings.hasTenJackQueenKingAce()) {
                new RoyalFlush(rankings.getHighCard());
            } else if (rankings.has5ConsecutiveValues()) {
                new StraightFlush(rankings.getHighCard());
            } else {
                new Flush(rankings.getHighCard());
            }
        }

        return null;
    }

    private RoyalFlush extractRoyalFlush() {
        // if (hasOne(Ranking.ACE)) {}
        return null;
    }
}
