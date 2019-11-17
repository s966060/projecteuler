package org.fde.projecteuler.problem_679.fail_fast.state_machine;

class Cursor<T extends Enum<T>> {
    private final Enum<T>  state;
    private final int count;

    public Cursor(Enum<T> state, int count) {
        this.state = state;
        this.count = count;
    }

    public Cursor<T> next(Enum<T> newState) {
        return new Cursor<>(newState, this.getCount());
    }

    public Cursor<T> nextIncrease(Enum<T>  newState) {
        return new Cursor<>(newState, this.getCount() + 1);
    }

    public Enum<T> getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public boolean hasOne() {
        return this.count == 1;
    }

    public boolean isValid() {
        return this.count <= 1;
    }
}
