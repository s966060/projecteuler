package org.fde.projecteuler.problem_679.fail_last;

import org.junit.Assert;
import org.junit.Test;

import static org.fde.projecteuler.problem_679.FreeFarea.*;

public class FreeFareaOneHintTest {

    // Runtime ~ 3 sec
    @Test
    public void oneHint_15() {
        int wordLength = 15;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_15, count);
    }

    // Runtime ~ 15 sec
    @Test
    public void oneHint_16() {
        int wordLength = 16;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_16, count);
    }

    // Runtime ~ 1 min 7 sec
    @Test
    public void oneHint_17() {
        int wordLength = 17;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_17, count);
    }
}
