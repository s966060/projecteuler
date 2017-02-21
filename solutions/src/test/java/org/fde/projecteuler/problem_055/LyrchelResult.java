package org.fde.projecteuler.problem_055;

public class LyrchelResult {
    private final boolean isLyrchel;
    private final LyrchelCursor cursor;

    public LyrchelResult(boolean isLyrchel,
            LyrchelCursor cursor) {

        this.isLyrchel = isLyrchel;
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "LyrchelResult{\n" +
               "isLyrchel=" + isLyrchel + ", \n" +
               "cursor=" + cursor +
               "\n}";
    }

    public boolean isLyrchel() {
        return isLyrchel;
    }
}
