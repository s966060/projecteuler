package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.List;

class Finder {
    private final FigurativeNumbersList figurativeNumbersList;
    private final Matches matches;

    Finder(FigurativeNumbersList figurativeNumbersList) {
        this.figurativeNumbersList = figurativeNumbersList;
        this.matches = new Matches();
    }

    void find() {
        FigurativeNumbers first = this.figurativeNumbersList.getFirst();

        FigurativeNumbersList nextFigurativeNumbersList
                = this.figurativeNumbersList.createWithout(first);

        for (Long value : first.getNumbers()) {
            FinderContext context = new FinderContext(value, first);

            match(context, nextFigurativeNumbersList);
        }
    }

    private void match(FinderContext context, FigurativeNumbersList figurativeNumbersList) {
        if (figurativeNumbersList.isEmpty()) {
            if (context.isClosed()) {
                matches.add(context);
            }
        } else {
            for (FigurativeNumbers figurativeNumbers : figurativeNumbersList) {
                long value = context.getCurrentValue();

                ListOfLong linkedValues = figurativeNumbers.getOnPostFixValue(value);

                for (Long linkedValue : linkedValues) {
                    FigurativeNumbersList nextFigurativeNumbersList
                            = figurativeNumbersList.createWithout(figurativeNumbers);

                    FinderContext newContext = context.next(
                            linkedValue, figurativeNumbers);

                    match(newContext, nextFigurativeNumbersList);
                }
            }
        }
    }

    Matches getMatches() {
        return matches;
    }
}
