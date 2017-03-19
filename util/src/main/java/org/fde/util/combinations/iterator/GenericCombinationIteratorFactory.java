package org.fde.util.combinations.iterator;

import java.util.List;

public class GenericCombinationIteratorFactory {
    public static <T> GenericCombinationIterator<T> createGenericCombinationIterator(
            List<T> input, int selectSize) {

        if(selectSize == 0) {
            return new ZeroSelectSizeGenericCombinationIterator();
        }
        else {
            return new NonZeroSelectSizeGenericCombinationIterator(
                    input, selectSize);
        }
    }
}
