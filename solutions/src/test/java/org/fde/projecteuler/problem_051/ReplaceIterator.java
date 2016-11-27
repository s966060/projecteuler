package org.fde.projecteuler.problem_051;

import java.util.Arrays;
import java.util.Iterator;

class ReplaceIterator implements Iterator<Replace> {
    private final int[] replaceIndexes;
    private final int sizeOfTargetNumber;

    public ReplaceIterator(int count, int sizeOfOriginalNumber) {
        this.replaceIndexes = new int[count];
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
        for (int i = 0; i < this.replaceIndexes.length; ++i) {
            int lastOne = getLastOne(i);

            if (this.replaceIndexes[i] != lastOne) {
                return true;
            }
        }

        return false;
    }

    /**
     * 0 1 2 x y
     * -> 0 1 x 3 y
     * -> 0 1 x y 4
     * -> 0 x 2 3 y
     * -> 0 x 2 y 4
     * -> 0 x y 3 4
     * -> x 1 2 3 y
     * -> ...
     * @return
     */
    @Override
    public Replace next() {
        for (int i = this.replaceIndexes.length - 1; i >= 0; --i) {
            int lastOne = getLastOne(i);

            if (this.replaceIndexes[i] < lastOne) {
                int value = this.replaceIndexes[i];
                setSequence(i, value);

                return new Replace(this.replaceIndexes);
            }
        }

        return Replace.NULL;
    }

    private void setSequence(int start, int value) {
        for (int j = start; j < this.replaceIndexes.length; ++j) {
            this.replaceIndexes[j] = value;
            ++value;
        }
    }

    private int getLastOne(int i) {
        return sizeOfTargetNumber - this.replaceIndexes.length + i;
    }

    public int[] getReplaceIndexes() {
        return replaceIndexes;
    }

    @Override
    public String toString() {
        return "ReplaceIterator{" +
                "replaceIndexes=" + Arrays.toString(replaceIndexes) +
                ", sizeOfTargetNumber=" + sizeOfTargetNumber +
                '}';
    }
}
