package org.fde.projecteuler.problem_051;

import java.util.Arrays;
import java.util.Iterator;

public class ReplaceIterator implements Iterator<Replace> {
    private final ReplaceFactory replaceFactory;

    private final int[] replaceIndexes;
    private final int sizeOfTargetNumber;
    private boolean first;

    public ReplaceIterator(ReplaceFactory replaceFactory, int count, int sizeOfOriginalNumber) {
        this.replaceFactory = replaceFactory;
        this.replaceIndexes = new int[count];
        this.sizeOfTargetNumber = sizeOfOriginalNumber + count;

        this.first = true;
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
        if (this.first) {
            return true;
        } else {
            for (int i = 0; i < this.replaceIndexes.length; ++i) {
                int lastOne = getLastOne(i);

                if (this.replaceIndexes[i] != lastOne) {
                    return true;
                }
            }

            return false;
        }
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
     *
     * @return
     */
    @Override
    public Replace next() {
        if (this.first) {
            this.first = false;
            return this.replaceFactory.createReplace(this.replaceIndexes);
        } else {
            for (int i = this.replaceIndexes.length - 1; i >= 0; --i) {
                int lastOne = getLastOne(i);

                if (this.replaceIndexes[i] < lastOne) {
                    int value = this.replaceIndexes[i] + 1;
                    setSequence(i, value);

                    return this.replaceFactory.createReplace(this.replaceIndexes);
                }
            }

            return this.replaceFactory._null_();
        }
    }

    private void setSequence(int startIndex, int value) {
        for (int j = startIndex; j < this.replaceIndexes.length; ++j) {
            this.replaceIndexes[j] = value;
            ++value;
        }
    }

    private int getLastOne(int i) {
        return sizeOfTargetNumber - this.replaceIndexes.length + i;
    }

    public int[] getReplaceIndexes() {
        return Arrays.copyOf(replaceIndexes, replaceIndexes.length);
    }

    @Override
    public String toString() {
        return "ReplaceIterator{" +
                "replaceIndexes=" + Arrays.toString(replaceIndexes) +
                ", sizeOfTargetNumber=" + sizeOfTargetNumber +
                '}';
    }
}
