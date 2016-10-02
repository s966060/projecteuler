package org.fde.projecteuler.problem_033;

import org.junit.Test;

import java.util.List;

public class DigitCancellingFractions {
    @Test
    public void digitCancellingFractions() {
        for(int digit = 1; digit <= 9; ++digit) {
            List<Division> divisions = Division.createDivisions(digit);

            for(Division d : divisions) {
                if(d.isCancellable()) {
                    System.out.println("d = " + d);
                }
            }
        }
    }
}
