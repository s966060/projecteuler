package org.fde.projecteuler.problem_033;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private final Number numerator;
    private final Number denumerator;

    public Division(Number numerator, Number denumerator) {
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    public boolean isCancellable() {
        double fraction = getFraction();
        double cancelledFraction = getCancelledFraction();

        boolean isCancellable = fraction == cancelledFraction;
        return isCancellable;
    }

    private double getCancelledFraction() {
        return numerator.cancelledValue / denumerator.cancelledValue;
    }

    private double getFraction() {
        return numerator.value / denumerator.value;
    }

    @Override
    public String toString() {
        return "Division{" +
                "numerator=" + numerator +
                ", denumerator=" + denumerator +
                ", fraction=" + getFraction() +
                ", cancelledFraction=" + getCancelledFraction() +
                '}';
    }

    static List<Division> createDivisions(int digit) {
        Validate.inclusiveBetween(1, 9, digit);

        List<Number> possibilities = new ArrayList<>();

        for(int otherDigit = 0; otherDigit <= 9; ++otherDigit){
            long value = digit * 10 + otherDigit;
            possibilities.add(new Number(value, otherDigit));
        }

        for(int otherDigit = 1; otherDigit <= 9; ++otherDigit) {
            long value = otherDigit * 10 + digit;
            possibilities.add(new Number(value, otherDigit));
        }

        List<Division> divisions = new ArrayList<>();

        for(Number numerator : possibilities) {
            for(Number denumerator : possibilities) {
                if(numerator.value < denumerator.value) {
                    divisions.add(new Division(numerator, denumerator));
                }
            }
        }

        return divisions;
    }

    public Number getNumerator() {
        return numerator;
    }

    public Number getDenumerator() {
        return denumerator;
    }
}
