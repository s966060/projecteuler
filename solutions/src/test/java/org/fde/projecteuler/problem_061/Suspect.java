package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;

/**
 * Created by filip on 26/03/2017.
 */
class Suspect {
    private ListOfLong suspect;

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
}
