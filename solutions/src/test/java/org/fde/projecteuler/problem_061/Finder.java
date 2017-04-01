package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;

class Finder {
    private final FigurativeNumbersList figurativeNumbersList;

    Finder(FigurativeNumbersList figurativeNumbersList) {
        this.figurativeNumbersList = figurativeNumbersList;
    }

    void find() {
        for (FigurativeNumbers figurativeNumbers : this.figurativeNumbersList) {
            FigurativeNumbersList nextFigurativeNumbersList
                    = this.figurativeNumbersList.createWithout(figurativeNumbers);

            for (Long value : figurativeNumbers.getNumbers()) {
                FinderContext context = new FinderContext(
                        value, figurativeNumbers);

                match(context, nextFigurativeNumbersList);
            }
        }
    }

    private void match(FinderContext context, FigurativeNumbersList figurativeNumbersList) {
        if (figurativeNumbersList.isEmpty()) {
            if (context.isClosed()) {
                System.out.println("context = " + context);
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
}
