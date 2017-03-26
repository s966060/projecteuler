package org.fde.projecteuler.problem_061;

public class Triangle implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * (n + 1) / 2;
    }
}
