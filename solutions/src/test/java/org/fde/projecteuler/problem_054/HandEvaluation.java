package org.fde.projecteuler.problem_054;

public class HandEvaluation {
    private final CardRankings rankings = new CardRankings();

    public HandEvaluation evaluate(Hand hand) {
        CardRankings rankings = new CardRankings();

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
