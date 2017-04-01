package org.fde.projecteuler.problem_061;

import java.util.ArrayList;
import java.util.List;

class Matches {
    private final List<Match> matches;

    Matches() {
        this.matches = new ArrayList<>();
    }

    void add(FinderContext matchAsFinderContext) {
        Match match = new Match(matchAsFinderContext);
        this.matches.add(match);
    }

    int size() {
        return this.matches.size();
    }

    @Override
    public String toString() {
        return "Matches{" +
                "matches=" + matches +
                '}';
    }

    public Match get(int index) {
        return this.matches.get(index);
    }
}
