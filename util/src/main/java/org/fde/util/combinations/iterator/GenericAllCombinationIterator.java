package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;

import java.util.ArrayList;
import java.util.List;

import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericCombinationIterator;

public class GenericAllCombinationIterator<T> implements GenericCombinationIterator<T> {
    private List iterators;

    public <T> GenericAllCombinationIterator(List<T> input) {
        this.iterators = new ArrayList();

        for (int selectSize = 0; selectSize <= input.size(); ++selectSize) {
            GenericCombinationIterator<T> iterator
                    = createGenericCombinationIterator(input, selectSize);

            this.iterators.add(iterator);
        }
    }

    @Override
    public boolean hasNext() {
        if (this.iterators.size() > 1) {
            return true;
        } else if (this.iterators.size() == 1) {
            GenericCombinationIterator<T> iterator = getFirstIterator();

            boolean hasNext = iterator.hasNext();
            return hasNext;
        } else {
            return false;
        }
    }

    @Override
    public GenericCombination<T> next() {
        GenericCombinationIterator<T> iterator = getFirstIterator();

        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            this.iterators.remove(0);
            return next();
        }
    }

    private GenericCombinationIterator<T> getFirstIterator() {
        Object iteratorAsObject = this.iterators.get(0);

        GenericCombinationIterator<T> iterator
                = (GenericCombinationIterator<T>) iteratorAsObject;

        return iterator;
    }
}
