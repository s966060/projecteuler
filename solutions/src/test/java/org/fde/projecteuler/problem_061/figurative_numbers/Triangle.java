package org.fde.projecteuler.problem_061.figurative_numbers;

public class Triangle implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (n + 1) / 2;
    }
}
