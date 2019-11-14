package org.fde.projecteuler.problem_679.state_machine;

class MachineFree {
    enum State {
        START, F, R, E1, E2;
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
                        if (ch == 'R') {
                            state = State.R;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case R:
                        if (ch == 'E') {
                            state = State.E1;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case E1:
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
