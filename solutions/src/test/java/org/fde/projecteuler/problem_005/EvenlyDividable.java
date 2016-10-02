package org.fde.projecteuler.problem_005;

import org.fde.util.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenlyDividable {
    @Test
    public void evenlyDividable() {
        int maxFactor = 20;

        int suspect = 0;

        nextSuspect:
        while (true) {
            suspect += 2;

            for (int factor = 1; factor <= maxFactor; ++factor) {
                int remainder = suspect % factor;

                if (remainder != 0) {
                    continue nextSuspect;
                }
            }

            break;

        }

        Logger.log("suspect = " + suspect);
        assertEquals(232792560, suspect);
    }
}
