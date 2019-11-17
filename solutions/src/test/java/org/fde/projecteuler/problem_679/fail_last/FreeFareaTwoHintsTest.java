package org.fde.projecteuler.problem_679.fail_last;

import org.junit.Assert;
import org.junit.Test;

import static org.fde.projecteuler.problem_679.FreeFarea.*;

public class FreeFareaTwoHintsTest {
    @Test
    public void twoHints_11() {
        int wordLength = 11;
        FreeFareaTwoHints engine = new FreeFareaTwoHints(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_11, count);
    }

    @Test
    public void twoHints_12() {
        int wordLength = 12;
        FreeFareaTwoHints engine = new FreeFareaTwoHints(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_12, count);
    }

    // Runtime ~ 3 sec
    @Test
    public void twoHints_15() {
        int wordLength = 15;
        FreeFareaTwoHints engine = new FreeFareaTwoHints(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_15, count);
    }

    // Runtime ~ 15 sec
    @Test
    public void twoHints_16() {
        int wordLength = 16;
        FreeFareaTwoHints engine = new FreeFareaTwoHints(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_16, count);
    }

    // Runtime ~ 1 min 7 sec
    @Test
    public void twoHints_17() {
        int wordLength = 17;
        FreeFareaTwoHints engine = new FreeFareaTwoHints(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(EXPECTED_17, count);
    }
}
