package org.fde.projecteuler.problem_033;

import org.apache.commons.lang3.Validate;
import org.fde.util.ListOfLong;

import java.util.List;

public class X {
    private final int digit;

    public X(int digit) {
        Validate.inclusiveBetween(1, 9, digit);
        this.digit = digit;
    }

    public List<Division> getDivisions() {
        ListOfLong possibilities = new ListOfLong();

        for(int otherDigit = 0; otherDigit <= 9; ++otherDigit){
            long value = digit * 10 + otherDigit;
            possibilities.add(value);
        }

        for(int otherDigit = 1; otherDigit <= 9; ++otherDigit) {
            long value = otherDigit * 10 + digit;
            possibilities.add(value);
        }

        for(Long numerator : possibilities) {
            for(Long denumberator : )
        }

        return possibilities;
    }
}
