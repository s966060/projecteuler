package org.fde.util.combinations.iterator;

class IndexList {
    final int[] indexes;
    private final int elementSize;

    IndexList(int elementSize, int selectSize) {
        this.indexes = new int[selectSize];
        this.elementSize = elementSize;

        for (int index = 0; index < this.indexes.length; ++index) {
            this.indexes[index] = index;
        }
    }

    public boolean hasNext() {
        int validFirstIndex = this.elementSize - this.indexes.length;
        int firstIndex = this.indexes[0];
        boolean hasNext = firstIndex <= validFirstIndex;
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
    void createNext() {
        int i;

        for (i = this.indexes.length - 1; i >= 0; --i) {
            ++this.indexes[i];

            int carryValue = 1 + this.elementSize - (this.indexes.length - i);

            if (this.indexes[i] < carryValue) {
                break;
            }
        }

        if (i < 0) {
            return;
        }

        boolean carry = (i < this.indexes.length - 1);

        if (carry) {
            int carryIndex = i;
            int indexValue = this.indexes[carryIndex];

            for (; carryIndex < this.indexes.length; ++carryIndex) {
                this.indexes[carryIndex] = indexValue;
                ++indexValue;
            }
        }
    }
}
