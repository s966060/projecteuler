package org.fde.projecteuler.problem_061;

public class Octagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (3 * n - 2);
    }
}
