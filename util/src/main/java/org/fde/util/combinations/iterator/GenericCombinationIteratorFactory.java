package org.fde.util.combinations.iterator;

import java.util.List;

public class GenericCombinationIteratorFactory {
    public static <T> GenericCombinationIterator<T> createGenericCombinationIterator(
            List<T> input, int selectSize) {

        if (selectSize == 0) {
            return new ZeroSelectSizeGenericCombinationIterator<T>();
        } else {
            return new NonZeroSelectSizeGenericCombinationIterator<T>(
                    input, selectSize);
        }
    }

    public static <T> GenericCombinationIterator<T> createGenericAllCombinationIterator(
            List<T> input) {

        return new GenericAllCombinationIterator<T>(input);
    }
}
