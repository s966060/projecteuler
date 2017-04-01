package org.fde.projecteuler.problem_061;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

class FigurativeNumbersList implements Iterable<FigurativeNumbers> {
    private final List<FigurativeNumbers> list;

    FigurativeNumbersList(FigurativeNumbers... figurativeNumbers) {
        this.list = new ArrayList<>(asList(figurativeNumbers));
    }

    FigurativeNumbersList(List<FigurativeNumbers> list) {
        this.list = list;
    }

    FigurativeNumbersList createWithout(
            FigurativeNumbers without) {

        List<FigurativeNumbers> newList = new ArrayList<>();

        for (FigurativeNumbers figurativeNumbers : this.list) {
            if (figurativeNumbers != without) {
                newList.add(figurativeNumbers);
            }
        }

        return new FigurativeNumbersList(newList);
    }

    @Override
    public Iterator<FigurativeNumbers> iterator() {
        return this.list.iterator();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public FigurativeNumbers getFirst() {
        FigurativeNumbers first = this.list.get(0);
        return first;
    }
}
