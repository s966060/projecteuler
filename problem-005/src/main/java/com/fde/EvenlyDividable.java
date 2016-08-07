package com.fde;

/**
 * Created by filipdelbaen on 08/08/16.
 */
public class EvenlyDividable {
    public static void main(String[] args) {
        int maxFactor = 20;

        int suspect = 0;

        nextSuspect:
        while(true) {
            suspect += 2;

            for(int factor = 1; factor <= maxFactor; ++factor) {
                int remainder = suspect % factor;

                if(remainder != 0) {
                    continue nextSuspect;
                }
            }

            break;

        }

        System.out.println("suspect = " + suspect);
    }
}
