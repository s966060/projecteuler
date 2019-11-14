package org.fde.projecteuler.problem_679.state_machine;

class MachineFree {
    enum State {
        START('X'), F('F'), R('R'), E1('E'), E2('E');

        final char ch;

        State(char ch) {
            this.ch = ch;
        }
    };

    static int go(String sentence) {
        State state = State.START;

        int count = 0;

        for (int index = 0; index < sentence.length(); ++index) {
            char ch = sentence.charAt(index);

            if (ch == State.F.ch) {
                state = State.F;
            }
            else {
                switch (state) {
                    case F:
                        if (ch == State.R.ch) {
                            state = State.R;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case R:
                        if (ch == State.E1.ch) {
                            state = State.E1;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case E1:
                        if (ch == State.E2.ch) {
                            state = State.START;
                            ++count;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                }
            }
        }

        return count;
    }
}
