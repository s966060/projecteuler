package org.fde.projecteuler.problem_679.state_machine;

class MachineReef {
    enum State {
        START, R, E1, E2, F;
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

        if (ch == 'R') {
            next = current.next(State.R);
        }
        else {
            final State state = (State) current.state;

            switch (state) {
                case START:
                    next = current.next(State.START);
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
                        next = current.next(State.E2);
                    } else {
                        next = current.next(State.START);
                    }
                    break;
                case E2:
                    if (ch == 'F') {
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
