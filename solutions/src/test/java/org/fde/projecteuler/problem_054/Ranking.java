package org.fde.projecteuler.problem_054;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

enum Ranking {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    static Ranking fromCode(String code) {
        switch (code) {
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            case "T":
                return TEN;
            case "J":
                return JACK;
            case "Q":
                return QUEEN;
            case "K":
                return KING;
            case "A":
                return ACE;
        }

        throw new IllegalArgumentException("Unknown Ranking " + code);
    }

    int getValue() {
        return ordinal() + 1;
    }

    Ranking next() {
        int next = ordinal() + 1;
        Validate.inclusiveBetween(0, values().length - 1, next);
        return values()[next];
    }

    List<Ranking> getThisAndNextFour() {
        List<Ranking> rankings = new ArrayList<>();

        Ranking ranking = this;
        for (int i = 0; i < 5; ++i) {
            rankings.add(ranking);
            ranking = ranking.next();
        }

        return rankings;
    }
}
