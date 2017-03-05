package org.fde.util;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.primes.PrimeFactors;

public class Ratio {
    private final long nominator;
    private final long denominator;

    public Ratio(long nominator, long denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public Ratio(long nominator) {
        this(nominator, 1);
    }

    public Ratio add(Ratio other) {
        return new Ratio(
                this.nominator * other.denominator + other.nominator * this.denominator,
                this.denominator * other.denominator);
    }

    public Ratio mul(Ratio other) {
        return new Ratio(
                this.nominator * other.nominator,
                this.denominator * other.denominator);
    }

    public Ratio div(Ratio other) {
        return new Ratio(
                this.nominator * other.denominator,
                this.denominator * other.nominator);
    }

    public Ratio simplify(PrimeFactors factors) {
        ListOfLong commonFactors = getCommonFactors(factors);

        long newNominator = this.nominator;
        long newDecnominator = this.denominator;

        for (Long factor : commonFactors) {
            newNominator /= factor;
            newDecnominator /= factor;
        }

        return new Ratio(newNominator, newDecnominator);
    }

    private ListOfLong getCommonFactors(PrimeFactors factors) {
        ListOfLong nominatorFactors = getPrimeFactors(factors, this.nominator);
        ListOfLong denominatorFactors = getPrimeFactors(factors, this.denominator);

        return nominatorFactors.getIntersection(denominatorFactors);
    }

    private ListOfLong getPrimeFactors(PrimeFactors factors, long value) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ListOfLong primeFactors = null;

        try {
            primeFactors = factors.getPrimeFactors(value);
            return primeFactors;
        }
        finally {
            if(stopWatch.getTime() > 1_00) {
                System.out.printf("### %n");
                System.out.printf("### (%,d) took a long time (%s) to factorize (%s) %n",
                        value, stopWatch, primeFactors);

                System.out.println();

                String map = "";

                map += String.format("map@put(%,dL$ createListOfLong(", value);

                for(int i = 0; i < primeFactors.size(); ++i) {
                    if(i > 0) {
                        map += "$ ";

                    }

                    map += String.format("%,dL", primeFactors.get(i));
                }

                map += "));";
                map = map.replace('.', '_').replace('$', ',').replace('@', '.');

                System.out.println(map);

                System.out.println();
                System.out.printf("### %n");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Ratio{nominator=%,d, denominator=%,d}",
                nominator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ratio ratio = (Ratio) o;

        if (nominator != ratio.nominator) return false;
        return denominator == ratio.denominator;
    }

    @Override
    public int hashCode() {
        int result = (int) (nominator ^ (nominator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    public long getDenominator() {
        return denominator;
    }

    public long getNominator() {
        return nominator;
    }

    public double getRatioAsDouble() {
        return ((double) nominator) / ((double) denominator);
    }
}
