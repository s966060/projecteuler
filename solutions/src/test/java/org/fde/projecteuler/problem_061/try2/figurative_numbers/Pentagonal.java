package org.fde.projecteuler.problem_061.try2.figurative_numbers;

public class Pentagonal implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (3 * n - 1) / 2;
    }
}
