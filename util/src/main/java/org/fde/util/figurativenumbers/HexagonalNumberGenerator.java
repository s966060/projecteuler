package org.fde.util.figurativenumbers;

public class HexagonalNumberGenerator extends FigurativeNumberGenerator {
    public HexagonalNumberGenerator() {
        super();
    }

    @Override
    protected long compute(long index) {
        long hexagonal = index * ((2 * index) - 1);
        return hexagonal;
    }
}
