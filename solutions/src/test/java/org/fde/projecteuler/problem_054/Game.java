package org.fde.projecteuler.problem_054;

public class Game {
    private final Hand one;
    private final Hand two;

    private Game(Hand one, Hand two) {
        this.one = one;
        this.two = two;
    }

    public static Game createGame(Hand one, Hand two) {
        if (one.isValid() && two.isValid()) {
            return new Game(one, two);
        }

        throw new IllegalArgumentException("invalid game - one " + one + " - two " + two);
    }

    @Override
    public String toString() {
        return "Game{" +
                "one=" + one +
                ", two=" + two +
                '}';
    }
}
