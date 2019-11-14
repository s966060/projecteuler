package org.fde.projecteuler.problem_679.state_machine;

class MachineReef {
    enum State {
        START, R, E1, E2, F;
    };

    static int go(String sentence) {
        State state = State.START;

        int count = 0;

        for (int index = 0; index < sentence.length(); ++index) {
            char ch = sentence.charAt(index);

            if (ch == 'R') {
                state = State.R;
            }
            else {
                switch (state) {
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
                            state = State.E2;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case E2:
                        if (ch == 'F') {
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
