package org.fde.projecteuler.problem_679.state_machine;

class MachineFree {
    enum State {
        START, F, R, E1, E2;
    };

    private final CursorList<State> cursorList = new CursorList<>(State.START);

    public Cursor<State> getCurrentCursor() {
        return this.cursorList.current();
    }

    public void push(String input) {
        for(int i = 0; i < input.length(); ++i) {
            char charAt = input.charAt(i);
            push(charAt);
        }
    }

    void push(char ch) {
        Cursor<State> current = this.cursorList.current();
        final Cursor<State> next;

        if (ch == 'F') {
            next = current.next(State.F);
        }
        else {
            final State state = (State) current.state;

            switch (state) {
                case START:
                    next = current.next(State.START);
                    break;
                case F:
                    if (ch == 'R') {
                        next = current.next(State.R);
                    }
                    else {
                        next = current.next(State.START);
                    }
                    break;
                case R:
                    if (ch == 'E') {
                        next = current.next(State.E1);
                    }
                    else {
                        next = current.next(State.START);
                    }
                    break;
                case E1:
                    if (ch == 'E') {
                        next = current.nextIncrease(State.START);
                    }
                    else {
                        next = current.next(State.START);
                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        this.cursorList.push(next);
    }
}
