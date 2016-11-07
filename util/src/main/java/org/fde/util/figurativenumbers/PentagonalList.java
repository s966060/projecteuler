package org.fde.util.figurativenumbers;

import org.fde.util.ListOfLong;

public class PentagonalList extends FigurativeNumberGenerator {
    public PentagonalList() {
        super();
    }

    @Override
    protected long compute(long index) {
        long pentagonal = index * ((3 * index) - 1) / 2;
        return pentagonal;
    }

}
