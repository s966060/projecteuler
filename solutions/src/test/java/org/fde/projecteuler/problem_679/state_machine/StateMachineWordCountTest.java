package org.fde.projecteuler.problem_679.state_machine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateMachineWordCountTest {
    @Test
    public void test_1() {
        String sentence = "FREE FREE FREE FREE FREE";
        int count = test(sentence);
        assertEquals(5, count);
    }

    @Test
    public void test_2() {
        String sentence = "FREEFREEFREEFREEFREE";
        int count = test(sentence);
        assertEquals(5, count);
    }

    @Test
    public void test_3() {
        String sentence = "   FREEREEFREEREEFREEREEF  ";
        int count = test(sentence);
        assertEquals(3, count);
    }

    @Test
    public void test_4() {
        String sentence = "   REEF REEF REEF REEF REEF   ";
        int count = test(sentence);
        assertEquals(0, count);
    }

    private int test(String sentence) {
        int count = MachineFree.go(sentence);
        return count;
    }
}

