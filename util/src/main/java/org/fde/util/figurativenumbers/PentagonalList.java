package org.fde.util.figurativenumbers;

import org.fde.util.ListOfLong;

public class PentagonalList {
    private final ListOfLong list;

    public PentagonalList() {
        this.list = new ListOfLong();
    }

    public long getByIndex(int index) {
        while (index >= this.list.size()) {
            long pentagonal = compute(this.list.size());
            this.list.add(pentagonal);
        }

        return this.list.get(index);
    }

    private long compute(long index) {
        long pentagonal = index * ((3 * index) - 1) / 2;
        return pentagonal;
    }

    public boolean isPentagonal(long value) {
        while (value > this.list.last()) {
            long pentagonal = compute(this.list.size());
            this.list.add(pentagonal);
        }

        return this.list.containsByBinarySearch(value);
    }
}
