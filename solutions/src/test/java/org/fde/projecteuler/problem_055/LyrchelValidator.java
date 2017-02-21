package org.fde.projecteuler.problem_055;

import static org.fde.projecteuler.problem_055.LyrchelCursor.createValueCursor;

public class LyrchelValidator {
    private final int iterations;

    public LyrchelValidator(int iterations) {
        this.iterations = iterations;
    }

    public LyrchelResult validate(int value) {
        LyrchelCursor cursor = createValueCursor(value, iterations);

        boolean isLyrchel = cursor.next();
        return new LyrchelResult(isLyrchel, cursor);
    }
}
