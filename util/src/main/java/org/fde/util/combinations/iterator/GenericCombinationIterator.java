package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;

import java.util.Iterator;
import java.util.List;

public class GenericCombinationIterator<T>
        implements Iterator<GenericCombination<T>>{

    public GenericCombinationIterator(List<T> input) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public GenericCombination<T> next() {
        return null;
    }
}
