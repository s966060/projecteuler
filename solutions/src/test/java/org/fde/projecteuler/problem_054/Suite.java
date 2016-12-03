package org.fde.projecteuler.problem_054;

enum Suite {
    DIAMOND, HEART, SPADE, CLUBS;

    public static Suite fromCode(String code) {
        switch (code) {
            case "C":
                return CLUBS;
            case "D":
                return DIAMOND;
            case "H":
                return HEART;
            case "S":
                return SPADE;
        }

        throw new IllegalArgumentException("Unknown code " + code);
    }
}
