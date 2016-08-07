package org.fde.problem_003;

public class Squares {
    private long base;

    public Squares() {
        this.base = 0;
    }

    public long getCurrentSquare() {
        return this.base * this.base;
    }

    public void nextSquare() {
        ++this.base;
    }

    public void forward(long toNumber) {
        while(toNumber > getCurrentSquare()) {
            nextSquare();
        }
    }

    public long getCurrentBase() {
        return this.base;
    }
}
