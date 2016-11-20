package org.fde.projecteuler.problem_050;

/**
 * Created by filip on 20/11/2016.
 */
class Suspect {
    private final long prime;
    private final int terms;
    private final long firstPrimeTerm;
    private final long lastPrimeTerm;

    public Suspect(long prime, int terms, long firstPrimeTerm, long lastPrimeTerm) {
        this.prime = prime;
        this.terms = terms;
        this.firstPrimeTerm = firstPrimeTerm;
        this.lastPrimeTerm = lastPrimeTerm;
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "prime=" + prime +
                ", terms=" + terms +
                ", firstPrimeTerm=" + firstPrimeTerm +
                ", lastPrimeTerm=" + lastPrimeTerm +
                '}';
    }

    public int getTerms() {
        return terms;
    }

    public long getFirstPrimeTerm() {
        return firstPrimeTerm;
    }

    public long getPrime() {
        return prime;
    }

    public long getLastPrimeTerm() {
        return lastPrimeTerm;
    }
}
