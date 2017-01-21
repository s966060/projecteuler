package org.fde.projecteuler.problem_054;

class HandEvaluation {
    private final CardRankings rankings = new CardRankings();
    private final CardSuites suites = new CardSuites();

    HandEvaluation evaluate(Hand hand) {
        rankings.add(hand);
        suites.add(hand);

        if (suites.hasFlush()) {
            if (rankings.hasTenJackQueenKingAce()) {
                new RoyalFlush(rankings.getHighCard());
            } else if (rankings.has5ConsecutiveValues()) {
                new StraightFlush(rankings.getHighCard());
            } else {
                new Flush(rankings.getHighCard());
            }
        }
        else if(rankings.hasFourOfAKind()) {
            new FourOfAKind(rankings.getFourOfAKindCards());
        }

        return null;
    }
}
