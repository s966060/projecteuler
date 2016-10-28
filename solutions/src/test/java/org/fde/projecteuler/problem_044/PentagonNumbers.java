package org.fde.projecteuler.problem_044;

import org.fde.util.ListOfLong;
import org.junit.Test;

public class PentagonNumbers {
    @Test
    public void pentagonNumbers() {
        ListOfLong numbers = new ListOfLong();

        long pentagonal = 1;
        numbers.add(pentagonal);
        long add = 4;

        boolean done = false;

        while (!done) {
            pentagonal += add;
            numbers.add(pentagonal);


            add += 3;
        }
    }
}
