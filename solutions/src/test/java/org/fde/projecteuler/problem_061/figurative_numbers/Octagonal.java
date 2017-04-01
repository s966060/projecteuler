package org.fde.projecteuler.problem_061.figurative_numbers;

public class Octagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (3 * n - 2);
    }
}
