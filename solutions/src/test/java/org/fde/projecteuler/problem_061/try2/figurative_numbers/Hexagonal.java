package org.fde.projecteuler.problem_061.try2.figurative_numbers;

public class Hexagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (2 * n - 1);
    }
}
