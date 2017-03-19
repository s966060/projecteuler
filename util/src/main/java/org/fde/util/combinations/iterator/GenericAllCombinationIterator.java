package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;

import java.util.ArrayList;
import java.util.List;

import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericCombinationIterator;

public class GenericAllCombinationIterator <T> implements GenericCombinationIterator<T> {
    private List iterators;

    public <T> GenericAllCombinationIterator(List<T> input) {
        this.iterators = new ArrayList();

        for(int selectSize = 0; selectSize < input.size(); ++selectSize) {
            GenericCombinationIterator<T> iterator
                    = createGenericCombinationIterator(input, selectSize);

            this.iterators.add(iterator);
        }
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = !this.iterators.isEmpty();
        return hasNext;
    }

    @Override
    public GenericCombination<T> next() {
        GenericCombinationIterator<T> iterator
                = (GenericCombinationIterator<T>) this.iterators.get(0);

        if(iterator.hasNext()) {
            return iterator.next();
        }
        else {
            this.iterators.remove(0);
            return next();
        }
    }
}
