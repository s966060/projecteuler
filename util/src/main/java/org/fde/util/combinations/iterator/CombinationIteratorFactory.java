package org.fde.util.combinations.iterator;

import org.fde.util.ListOfLong;

import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericAllCombinationIterator;
import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericCombinationIterator;

public class CombinationIteratorFactory {
    public static CombinationIterator createCombinationIterator(
            ListOfLong input, int selectSize) {

        GenericCombinationIterator<Long> iterator
                = createGenericCombinationIterator(
                        input.getInternalList(), selectSize);

        return new CombinationIterator(iterator);
    }

    public static CombinationIterator createAllCombinationIterator(
            ListOfLong input) {

        GenericCombinationIterator<Long> iterator
                = createGenericAllCombinationIterator(input.getInternalList());

        return new CombinationIterator(iterator);
    }
}
