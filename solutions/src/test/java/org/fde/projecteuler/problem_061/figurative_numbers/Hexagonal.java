package org.fde.projecteuler.problem_061.figurative_numbers;

public class Hexagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (2 * n - 1);
    }
}
