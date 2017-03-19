package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;

class Context {
    private final ListOfLong numbers;
    private int index;

    Context(ListOfLong numbers, int index) {
        this.numbers = numbers;
        this.index = index;
    }

    Long getValue() {
        return this.numbers.get(this.index);
    }

    boolean hasNext() {
        boolean hasNext = (this.index < this.numbers.size());
        return hasNext;
    }

    void next() {
        ++this.index;
    }

    public ListOfLong getNumbers() {
        return numbers;
    }

    public int getIndex() {
        return index;
    }
}
