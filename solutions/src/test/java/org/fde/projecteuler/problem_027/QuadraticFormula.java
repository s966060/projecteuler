package org.fde.projecteuler.problem_027;

import org.fde.util.primes.PrimeBuilder;

import java.io.PrintStream;

class QuadraticFormula {
    private final int a;
    private final int b;

    private PrimeBuilder primeBuilder;

    public void setPrimeBuilder(PrimeBuilder primeBuilder) {
        this.primeBuilder = primeBuilder;
    }

    public QuadraticFormula(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public long evaluate(int n) {
        long result = n * n + a * n + b;
        return result;
    }

    public int evaluate(PrintStream out) {
        for (int n = 0; n < 1000; ++n) {
            long result = evaluate(n);

            if (!primeBuilder.isPrime(result)) {
                return n;
            }

            if (out != null) {
                out.printf("n = %s - prime = %s%n", n, result);
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "QuadraticFormula{" +
                "a=" + a +
                ", b=" + b +
                ", primeBuilder=" + primeBuilder +
                '}';
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
