package org.fde.projecteuler.problem_051;

import java.util.Iterator;

class ReplaceIterator implements Iterator<Replace> {
    private final int[] iterators;
    private final int sizeOfTargetNumber;

    public ReplaceIterator(int count, int sizeOfOriginalNumber) {
        this.iterators = new int[count];
        this.sizeOfTargetNumber = sizeOfOriginalNumber + count;

        setSequence(0, 0);
    }

    /**
     * digits
     * |     iterator indexes
     * |     |
     * x y z 3 4 5
     * iterator.length = 3
     * sizeOfTargetNumber = 6
     * iterator[0] = 3 == 6 - 3 + 0
     * iterator[1] = 4 == 6 - 3 + 1
     * iterator[2] = 5 == 6 - 3 + 2
     */
    @Override
    public boolean hasNext() {
        for (int i = 0; i < this.iterators.length; ++i) {
            int lastOne = getLastOne(i);

            if (this.iterators[i] != lastOne) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Replace next() {
        for (int i = this.iterators.length - 1; i >= 0; --i) {
            int lastOne = getLastOne(i);

            if (this.iterators[i] < lastOne) {
                int value = this.iterators[i];
                setSequence(i, value);

                return new Replace(this.iterators);
            }
        }

        return Replace.NULL;
    }

    private void setSequence(int start, int value) {
        for (int j = start; j < this.iterators.length; ++j) {
            this.iterators[j] = value;
            ++value;
        }
    }

    private int getLastOne(int i) {
        return sizeOfTargetNumber - this.iterators.length + i;
    }
}
