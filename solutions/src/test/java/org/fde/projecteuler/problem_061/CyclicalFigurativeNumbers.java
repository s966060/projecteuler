package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CyclicalFigurativeNumbers {
    @Test
    public void cyclicalFigurativeNumbers() {
        FigurativeNumber[] figurativeNumbers = {
                new Square(), new Pentagonal(), new Hexagonal(),
                new Heptagonal(), new Octagonal()};

        List<ListOfLong> suspects = new ArrayList<>();

        ListOfLong start = create(new Triangle());
        suspects.add(start);

        for (FigurativeNumber figurativeNumber : figurativeNumbers) {
            ListOfLong next = create(figurativeNumber);
            start = getConnected(start, next);
            suspects.add(start);
        }

        System.out.println("start = " + start);

        for(ListOfLong suspect:suspects) {
            System.out.println("suspect = " + suspect);
        }
    }

    private ListOfLong getConnected(ListOfLong first, ListOfLong second) {
        ListOfLong suspects = new ListOfLong();

        for (int i = 0; i < first.size(); ++i) {
            for (int j = 0; j < second.size(); ++j) {
                long firstNumber = first.get(i);
                long secondNumber = second.get(j);

                if (isConnected(firstNumber, secondNumber)) {
                    suspects.add(secondNumber);
                }
            }
        }

        return suspects;
    }

    private boolean isConnected(long firstNumber, long secondNumber) {
        long firstLastDigits = (firstNumber % 100);
        long secondFirstDigits = (secondNumber / 100);

        boolean isConnected = (firstLastDigits == secondFirstDigits);
        return isConnected;
    }

    private ListOfLong create(FigurativeNumber figurativeNumber) {
        ListOfLong suspects = new ListOfLong();

        long suspect = 0;
        int n = 0;

        while (suspect < 10_000) {
            suspect = figurativeNumber.compute(n);

            if (suspect >= 1_000 && suspect < 10_000) {
                suspects.add(suspect);
            }

            ++n;
        }

        return suspects;
    }
}
