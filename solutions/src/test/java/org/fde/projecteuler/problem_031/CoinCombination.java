package org.fde.projecteuler.problem_031;

import java.util.ArrayList;
import java.util.List;

class CoinCombination {
    private final List<Participant> combination;

    CoinCombination() {
        this.combination = new ArrayList<>();
    }

    public CoinCombination(CoinCombination other) {
        this.combination = new ArrayList<>(other.combination);
    }

    void add(Participant p) {
        this.combination.add(p);
    }

    public Long sum() {
        long sum = 0;

        for (Participant p : combination) {
            sum += p.getAmount();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "CoinCombination{" +
                "combination=" + combination +
                '}';
    }

    public boolean hasCoin(Participant other) {
        for (Participant p : combination) {
            if (p.isSameCoin(other)) {
                return true;
            }
        }

        return false;
    }
}
