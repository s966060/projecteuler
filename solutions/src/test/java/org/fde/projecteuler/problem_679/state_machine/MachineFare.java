package org.fde.projecteuler.problem_679.state_machine;

class MachineFare {
    enum State {
        START, F, A, R, E;
    };

    static int go(String sentence) {
        State state = State.START;

        int count = 0;

        for (int index = 0; index < sentence.length(); ++index) {
            char ch = sentence.charAt(index);

            if (ch == 'F') {
                state = State.F;
            }
            else {
                switch (state) {
                    case F:
                        if (ch == 'A') {
                            state = State.A;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case A:
                        if (ch == 'R') {
                            state = State.R;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case R:
                        if (ch == 'E') {
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
