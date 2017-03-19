package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;

class Context {
    final ListOfLong numbers;
    int index;

    Context(ListOfLong numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    Long getValue() {
        return this.numbers.get(this.index);
    }

    boolean hasNext() {
        boolean hasNext = (this.index < this.numbers.size());
        return hasNext;
    }
}
