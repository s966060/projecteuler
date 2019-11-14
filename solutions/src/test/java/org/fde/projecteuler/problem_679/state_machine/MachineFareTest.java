package org.fde.projecteuler.problem_679.state_machine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineFareTest {
    @Test
    public void test_1() {
        String sentence = "FARE FARE FARE";
        int count = test(sentence);
        assertEquals(3, count);
    }

    @Test
    public void test_2() {
        String sentence = "FAREFAREFAREFAREFAREFAREFARE";
        int count = test(sentence);
        assertEquals(7, count);
    }

    @Test
    public void test_3() {
        String sentence = "   FREFAREEREEFAREREEREEFAREEREEF  ";
        int count = test(sentence);
        assertEquals(3, count);
    }

    @Test
    public void test_4() {
        String sentence = "   FREE FREE FREE FREE FREE   ";
        int count = test(sentence);
        assertEquals(0, count);
    }

    @Test
    public void test_5() {
        String sentence = "FAREEFREEFARE";
        int count = test(sentence);
        assertEquals(2, count);
    }

    @Test
    public void test_6() {
        String sentence = "FREEFAREA";
        int count = test(sentence);
        assertEquals(1, count);
    }

    private int test(String sentence) {
        MachineFare machine = new MachineFare();
        machine.push(sentence);
        Cursor<MachineFare.State> cursor = machine.getCurrentCursor();
        return cursor.count;
    }
}

