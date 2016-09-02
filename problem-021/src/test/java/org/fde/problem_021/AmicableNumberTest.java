package org.fde.problem_021;

import org.fde.util.ListOfLong;
import org.fde.util.primes.Divisors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class Target {
    private final int number;
    private final int d;

    public Target(int number, int d) {
        this.number = number;
        this.d = d;
    }

    public int getNumber() {
        return number;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Target{" +
                "number=" + number +
                ", d=" + d +
                '}';
    }
}

class Match {
    private final Target a;
    private final Target b;

    public Match(Target a, Target b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Match{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public Target getA() {
        return a;
    }

    public Target getB() {
        return b;
    }
}

public class AmicableNumberTest {
    @Test
    public void sumOfAmicableNumbersLessThan_10000() {
        Divisors divisors = new Divisors();

        List<Target> targets = new ArrayList<>();

        for (int number = 0; number <= 10_000; ++number) {
            ListOfLong list = divisors.getProperDivisors(number);
            int d = (int) list.getSum();

            targets.add(new Target(number, d));
        }

        List<Match> matches = new ArrayList<>();

        for (int index = 0; index < targets.size(); ++index) {
            Target a = targets.get(index);

            if (a != null) {
                if (a.getD() < targets.size()) {
                    Target b = targets.get(a.getD());

                    if (b != null) {
                        if (b.getNumber() != a.getNumber()) {
                            if (b.getD() == a.getNumber()) {
                                matches.add(new Match(a, b));

                                targets.set(b.getNumber(), null);
                            }
                        }
                    }
                }
            }
        }

        System.out.println("matches = " + matches);

        int sum = 0;

        for (Match match : matches) {
            sum += match.getA().getNumber();
            sum += match.getB().getNumber();
        }

        System.out.println("sum = " + sum);

        assertEquals(31626, sum);
    }
}
