package org.fde.projecteuler.problem_061;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CyclicalFigurativeNumbers {
    @Test
    public void cyclicalFigurativeNumbers() {
        FigurativeNumber[] figurativeNumbers = {
                new Square(), new Pentagonal(), new Hexagonal(),
                new Heptagonal(), new Octagonal()};

        List<Suspect> suspects = create(new Triangle());

        for (FigurativeNumber figurativeNumber : figurativeNumbers) {
            List<Suspect> nextSuspects = getConnected(suspects, figurativeNumber);
            suspects = nextSuspects;
        }

        for (Suspect suspect : suspects) {
            if(suspect.isConnected()) {
                System.out.println("suspect = " + suspect);
            }
        }

        assertEquals(6, suspects.size());

        Suspect answer = suspects.get(5);

        long sum = answer.getSum();

        assertEquals(134, sum);
    }

    private List<Suspect> getConnected(List<Suspect> first,
                                       FigurativeNumber figurativeNumber) {

        List<Suspect> newSuspects = new ArrayList<>();

        List<Suspect> second = create(figurativeNumber);

        for (Suspect firstSuspect : first) {
            long firstSuspectNumber = firstSuspect.getLast();

            for (Suspect secondSuspect : second) {
                long secondSuspectNumber = secondSuspect.getLast();

                if (isConnected(firstSuspectNumber, secondSuspectNumber)) {
                    Suspect suspect = new Suspect(firstSuspect, secondSuspectNumber);
                    newSuspects.add(suspect);
                }
            }

        }

        return newSuspects;
    }

    private boolean isConnected(long firstNumber, long secondNumber) {
        boolean isConnected = Suspect.isConnected(firstNumber, secondNumber);
        return isConnected;
    }

    private List<Suspect> create(FigurativeNumber figurativeNumber) {
        List<Suspect> suspects = new ArrayList<>();

        long value = 0;
        int n = 0;

        while (value < 100_000) {
            value = figurativeNumber.compute(n);

            if (value >= 1_000 && value < 100_000) {
                Suspect suspect = new Suspect(value);
                suspects.add(suspect);
            }

            ++n;
        }

        return suspects;
    }
}
