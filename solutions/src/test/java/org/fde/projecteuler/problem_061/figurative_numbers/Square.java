package org.fde.projecteuler.problem_061.figurative_numbers;

public class Square implements FigurativeNumber {
    @Override
    public long compute(int n) {
        return n * n;
    }

    @Override
    public String toString() {
        return "Square{}";
    }
}
