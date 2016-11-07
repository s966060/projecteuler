package org.fde.util.figurativenumbers;

public class PentagonalNumberGenerator extends FigurativeNumberGenerator {
    public PentagonalNumberGenerator() {
        super();
    }

    @Override
    protected long compute(long index) {
        long pentagonal = index * ((3 * index) - 1) / 2;
        return pentagonal;
    }
}
