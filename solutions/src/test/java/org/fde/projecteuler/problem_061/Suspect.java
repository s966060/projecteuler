package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;

/**
 * Created by filip on 26/03/2017.
 */
class Suspect {
    private ListOfLong suspect;
    private boolean connected;

    Suspect(long suspectNumber) {
        this.suspect = new ListOfLong();
        this.suspect.add(suspectNumber);
    }

    public Suspect(Suspect suspect, long suspectNumber) {
        this.suspect = new ListOfLong(suspect.suspect);
        this.suspect.add(suspectNumber);
    }

    long getLast() {
        return this.suspect.getLast();
    }

    long getSum() {
        return this.suspect.getSum();
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "suspect=" + suspect +
                '}';
    }

    public boolean isConnected() {
        Long firstNumber = this.suspect.get(0);
        Long lastNumber = this.suspect.get(5);
        boolean isConnected = isConnected(lastNumber, firstNumber);
        return isConnected;
    }

    public static boolean isConnected(long firstNumber, long secondNumber) {
        long firstLastDigits = (firstNumber % 100);
        long secondFirstDigits = (secondNumber / 100);

        if(secondFirstDigits >= 100) {
            secondFirstDigits /= 10;
        }

        boolean isConnected = (firstLastDigits == secondFirstDigits);
        return isConnected;
    }
}
