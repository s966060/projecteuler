package org.fde.projecteuler;

import org.fde.util.Logger;

public class EvenlyDividable {
    public static void main(String[] args) {
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
    }
}
