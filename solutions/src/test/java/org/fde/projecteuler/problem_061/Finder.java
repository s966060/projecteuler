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
                match(value, nextFigurativeNumbersList);
            }
        }
    }

    private void match(long value, FigurativeNumbersList figurativeNumbersList) {
        if (figurativeNumbersList.isEmpty()) {
            System.out.println("value = " + value);
        } else {
            for (FigurativeNumbers figurativeNumbers : figurativeNumbersList) {
                ListOfLong linkedValues = figurativeNumbers.getLinkedOnPrefix(value);

                for (Long linkedValue : linkedValues) {
                    FigurativeNumbersList nextFigurativeNumbersList
                            = figurativeNumbersList.createWithout(figurativeNumbers);

                    match(linkedValue, nextFigurativeNumbersList);
                }
            }
        }
    }
}
