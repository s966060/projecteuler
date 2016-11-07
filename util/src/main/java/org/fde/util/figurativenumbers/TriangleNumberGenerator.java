package org.fde.util.figurativenumbers;

public class TriangleNumberGenerator extends FigurativeNumberGenerator {
    public TriangleNumberGenerator() {
        super();
    }

    @Override
    protected long compute(long index) {
        long triangle = index * (index + 1) / 2;
        return triangle;
    }
}
