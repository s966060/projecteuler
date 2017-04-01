package org.fde.projecteuler.problem_061.try2.figurative_numbers;

public class Triangle implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (n + 1) / 2;
    }
}
