package org.fde.util.combinations.iterator;

class IndexList {
    final int[] indexes;
    private final int elementSize;
    private final int selectSize;

    IndexList(int elementSize, int selectSize) {
        this.indexes = new int[selectSize];
        this.elementSize = elementSize;
        this.selectSize = selectSize;

        for (int index = 0; index < selectSize; ++index) {
            this.indexes[index] = index;
        }
    }

    public boolean hasNext() {
        boolean hasNext = this.indexes[0] <= (this.elementSize - this.selectSize);
        return hasNext;
    }

    /**
     * combination (6, 3)
     * we start with [ 0, 1, 2 ]
     * -> [ 0, 1, 3 ] -> [ 0, 1, 4 ] -> [ 0, 1, 5 ] -> [ 0, 1, 6 ]
     * the [ 0, 1, 6 ] is a carry situation -> [ 0, 2, 6 ] which we transform into [ 0, 2, 3 ]
     * ...
     * [ 0, 4, 5 ] -> [ 0, 4, 6 ] -> [ 0, 5, 6 ] -> [ 1, 2, 3 ]
     */
    public void createNext() {
        int i;

        for (i = this.indexes.length - 1; i >= 0; ++i) {
            ++this.indexes[i];

            if (this.indexes[i] < (elementSize - i)) {
                break;
            }
        }

        boolean carry = (i < this.indexes.length - 2);

        if (carry) {
            int carryIndex = i;
            int indexValue = this.indexes[carryIndex];

            for(; carryIndex < this.indexes.length; ++carryIndex) {
                this.indexes[carryIndex] = indexValue;
                ++indexValue;
            }
        }
    }
}
