package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ZeroSelectSizeGenericCombinationIterator<T>
        implements GenericCombinationIterator<T> {

    private final Iterator<GenericCombination<T>> iterator;

    ZeroSelectSizeGenericCombinationIterator() {
        List<GenericCombination<T>> list = new ArrayList<>();
        list.add(new GenericCombination<>());

        this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public GenericCombination<T> next() {
        return this.iterator.next();
    }
}
