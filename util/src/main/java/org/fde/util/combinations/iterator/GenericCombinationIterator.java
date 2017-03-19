package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;

import java.util.Iterator;
import java.util.List;

public class GenericCombinationIterator<T>
        implements Iterator<GenericCombination<T>> {

    private final List<T> input;
    private final IndexList indexList;

    public GenericCombinationIterator(List<T> input, int selectSize) {
        this.input = input;
        this.indexList = new IndexList(input.size(), selectSize);
    }

    @Override
    public boolean hasNext() {
        return this.indexList.hasNext();
    }

    @Override
    public GenericCombination<T> next() {
        GenericCombination<T> combination = new GenericCombination<T>();

        for (int index : this.indexList.indexes) {
            T value = this.input.get(index);

            combination.add(value);
        }

        createNext();
        return combination;
    }

    private void createNext() {
        this.indexList.createNext();
    }
}
