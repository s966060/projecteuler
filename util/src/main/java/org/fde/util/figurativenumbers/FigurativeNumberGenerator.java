package org.fde.util.figurativenumbers;

import org.fde.util.ListOfLong;

public abstract class FigurativeNumberGenerator {
    protected final ListOfLong list;

    public FigurativeNumberGenerator() {
        this.list = new ListOfLong();
    }

    public long getByIndex(int index) {
        while (index >= this.list.size()) {
            long pentagonal = compute(this.list.size());
            this.list.add(pentagonal);
        }

        return this.list.get(index);
    }

    protected abstract long compute(long index);

    public boolean isPentagonal(long value) {
        while (value > this.list.last()) {
            long pentagonal = compute(this.list.size());
            this.list.add(pentagonal);
        }

        return this.list.containsByBinarySearch(value);
    }
}
