package org.fde.projecteuler.problem_679.state_machine;

public class MachineArea {
    enum State {
        START, A1, R, E, A2;
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

    public void push(char input) {
        Cursor<State> current = this.cursorList.current();
        final Cursor<State> next;

        if (input == 'A') {
            if (current.getState() == State.START) {
                next = current.next(State.A1);
            }
            else
            if (current.getState() == State.E) {
                next = current.nextIncrease(State.A1);
            }
            else
            if (current.getState() == State.A1) {
                next = current.next(State.A1);
            }
            else
            if (current.getState() == State.R) {
                next = current.next(State.A1);
            }
            else {
                next = current.next(State.START);
            }
        }
        else {
            final State state = (State) current.getState();

            switch (state) {
                case START:
                    next = current.next(State.START);
                    break;
                case A1:
                    if (input == 'R') {
                        next = current.next(State.R);
                    }
                    else {
                        next = current.next(State.START);
                    }
                    break;
                case R:
                    if (input == 'E') {
                        next = current.next(State.E);
                    }
                    else {
                        next = current.next(State.START);
                    }
                    break;
                case E:
                    if (input == 'A') {
                        next = current.nextIncrease(State.A2);
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

    public void pop() {
        this.cursorList.pop();
    }
}
