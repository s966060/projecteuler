package org.fde.projecteuler.problem_679.state_machine;

public class MachineArea {
    enum State {
        START, A1, R, E, A2;
    };

    static int go(String sentence) {
        State state = State.START;

        int count = 0;

        for (int index = 0; index < sentence.length(); ++index) {
            char ch = sentence.charAt(index);

            if (ch == 'A') {
                if (state == State.START) {
                    state = State.A1;
                }
                else
                if (state == State.E) {
                    ++count;
                    state = State.A1;
                }
            }
            else {
                switch (state) {
                    case A1:
                        if (ch == 'R') {
                            state = State.R;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case R:
                        if (ch == 'E') {
                            state = State.E;
                        }
                        else {
                            state = State.START;
                        }
                        break;
                    case E:
                        if (ch == 'A') {
                            state = State.A2;
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
