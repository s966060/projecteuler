package org.fde.projecteuler.problem_054;

import static org.fde.projecteuler.problem_054.Flush.createFlush;
import static org.fde.projecteuler.problem_054.FourOfAKind.createFourOfAKind;
import static org.fde.projecteuler.problem_054.RoyalFlush.createRoyalFlush;
import static org.fde.projecteuler.problem_054.StraightFlush.createStraightFlush;

class HandEvaluation {
    private final CardRankings rankings = new CardRankings();
    private final CardSuites suites = new CardSuites();

    HandEvaluation evaluate(Hand hand) {
        rankings.add(hand);
        suites.add(hand);

        if (suites.hasFlush()) {
            if (rankings.hasTenJackQueenKingAce()) {
                createRoyalFlush(rankings.getAllCards());
            } else if (rankings.has5ConsecutiveValues()) {
                createStraightFlush(rankings.getAllCards());
            } else {
                createFlush(rankings.getAllCards());
            }
        } else if (rankings.hasFourOfAKind()) {
            createFourOfAKind(rankings.getFourOfAKindCards());
        }

        return null;
    }
}
