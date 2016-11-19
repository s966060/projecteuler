package org.fde.projecteuler.problem_047;

import org.fde.util.ListOfLong;

class Found {
    ListOfLong list;

    Found() {
        reset();
    }

    void reset() {
        list = new ListOfLong();
    }

    void add(long number) {
        if (!list.isEmpty()) {
            if (list.last() + 1 != number) {
                reset();
            }
        }

        list.add(number);
    }

    boolean found() {
        return list.size() == 4;
    }

    @Override
    public String toString() {
        return "Found{" +
                "list=" + list +
                '}';
    }
}
