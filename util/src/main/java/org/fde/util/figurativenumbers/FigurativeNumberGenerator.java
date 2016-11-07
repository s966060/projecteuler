package org.fde.util.figurativenumbers;

import org.fde.util.ListOfLong;

public abstract class FigurativeNumberGenerator {
    protected final ListOfLong list;

    public FigurativeNumberGenerator() {
        this.list = new ListOfLong();
    }

    public long getByIndex(int index) {
        while (index >= this.list.size()) {
            long number = compute(this.list.size());
            this.list.add(number);
        }

        return this.list.get(index);
    }

    protected abstract long compute(long index);

    public boolean isFigurativeNumber(long value) {
        if(this.list.isEmpty()) {
            getByIndex(0);
        }

        while (value > this.list.last()) {
            long number = compute(this.list.size());
            this.list.add(number);
        }

        return this.list.containsByBinarySearch(value);
    }
}
