package org.fde.projecteuler.problem_054;

public class HandEvaluation {
    private final Rankings rankings = new Rankings();

    public HandEvaluation evaluate(Hand hand) {
        Rankings rankings = new Rankings();

        for (Card card : hand) {
            rankings.add(card);
        }

        RoyalFlush royalFlush = extractRoyalFlush();
        return null;
    }

    private RoyalFlush extractRoyalFlush() {
        // if (hasOne(Ranking.ACE)) {}
        return null;
    }
}
