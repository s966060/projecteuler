package org.fde.projecteuler.problem_679.fail_fast.state_machine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineReefTest {
    @Test
    public void test_1() {
        String sentence = "REEF REEF REEF REEF REEF REEF";
        int count = test(sentence);
        assertEquals(6, count);
    }

    @Test
    public void test_2() {
        String sentence = "REEFREEFREEFREEFREEFREEF";
        int count = test(sentence);
        assertEquals(6, count);
    }

    @Test
    public void test_3() {
        String sentence = "   FREEREEFREEREEFREEREEF  ";
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
        String sentence = "REEFREE";
        int count = test(sentence);
        assertEquals(1, count);
    }

    @Test
    public void test_6() {
        String sentence = "FREFREEFRE";
        int count = test(sentence);
        assertEquals(1, count);
    }

    private int test(String sentence) {
        MachineReef  machine = new MachineReef();
        machine.push(sentence);
        Cursor<MachineReef.State> cursor = machine.getCurrentCursor();
        return cursor.getCount();
    }
}

