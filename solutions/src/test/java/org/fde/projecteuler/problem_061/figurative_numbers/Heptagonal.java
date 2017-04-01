package org.fde.projecteuler.problem_061.figurative_numbers;

public class Heptagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (5 * n - 3) / 2;
    }
}
