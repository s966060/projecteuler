package org.fde.projecteuler.problem_679.state_machine;

class Cursor<T extends Enum<T>> {
    final Enum<T>  state;
    final int count;

    public Cursor(Enum<T> state, int count) {
        this.state = state;
        this.count = count;
    }

    public Cursor<T> next(Enum<T> newState) {
        return new Cursor<>(newState, this.count);
    }

    public Cursor<T> nextIncrease(Enum<T>  newState) {
        return new Cursor<>(newState, this.count + 1);
    }
}
