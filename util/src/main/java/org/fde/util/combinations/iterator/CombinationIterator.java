package org.fde.util.combinations.iterator;

import org.fde.util.combinations.Combination;
import org.fde.util.combinations.GenericCombination;

import java.util.Iterator;

public class CombinationIterator implements Iterator<Combination> {
    private final GenericCombinationIterator<Long> iterator;

    CombinationIterator(GenericCombinationIterator<Long> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Combination next() {
        GenericCombination<Long> next = this.iterator.next();

        return new Combination(next);
    }
}
