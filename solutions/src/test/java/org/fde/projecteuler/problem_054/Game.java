package org.fde.projecteuler.problem_054;

public class Game {
    private final Hand one;
    private final Hand two;

    public Game(Hand one, Hand two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public String toString() {
        return "Game{" +
                "one=" + one +
                ", two=" + two +
                '}';
    }
}
