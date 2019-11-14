package org.fde.projecteuler.problem_679;

import org.junit.Assert;
import org.junit.Test;

public class FreeFarea {
    static final char [] ALPHABET = { 'F', 'A', 'R', 'E'};
    static final String [] TARGETS = { "FREE", "FARE", "REEF", "AREA"};

    // Runtime ~ 35 sec
    @Test
    public void bruteForce_15() {
        int wordLength = 15;
        FreeFareaBruteForce engine = new FreeFareaBruteForce(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(72863, count);
    }

    // Runtime ~ 2min 25 sec
    @Test
    public void bruteForce_16() {
        int wordLength = 16;
        FreeFareaBruteForce engine = new FreeFareaBruteForce(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(367804, count);
    }

    // Runtime ~ 10 min
    @Test
    public void bruteForce_17() {
        int wordLength = 17;
        FreeFareaBruteForce engine = new FreeFareaBruteForce(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(1812443, count);
    }

    // Runtime ~ 3 sec
    @Test
    public void oneHint_15() {
        int wordLength = 15;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(72863, count);
    }

    // Runtime ~ 15 sec
    @Test
    public void oneHint_16() {
        int wordLength = 16;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(367804, count);
    }

    // Runtime ~ 1 min 7 sec
    @Test
    public void oneHint_17() {
        int wordLength = 17;
        FreeFareaOneHint engine = new FreeFareaOneHint(wordLength);
        int count = engine.go();

        System.out.println("wordLength = " + wordLength);
        System.out.println("count = " + count);
        Assert.assertEquals(1812443, count);
    }
}