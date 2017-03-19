package org.fde.util.combinations.iterator;

import org.fde.util.combinations.GenericCombination;
import org.fde.util.combinations.GenericCombinationList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericCombinationIterator;
import static org.junit.Assert.assertEquals;

public class GenericCombinationIteratorTest {
    @Test
    public void empty_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(0);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>());

        check(expected, actual);
    }

    @Test
    public void one_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(1);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>(1L))
                .add(new GenericCombination<>(2L))
                .add(new GenericCombination<>(3L))
                .add(new GenericCombination<>(4L))
                .add(new GenericCombination<>(5L));

        check(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(2);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>(1L, 2L))
                .add(new GenericCombination<>(1L, 3L))
                .add(new GenericCombination<>(1L, 4L))
                .add(new GenericCombination<>(1L, 5L))
                .add(new GenericCombination<>(2L, 3L))
                .add(new GenericCombination<>(2L, 4L))
                .add(new GenericCombination<>(2L, 5L))
                .add(new GenericCombination<>(3L, 4L))
                .add(new GenericCombination<>(3L, 5L))
                .add(new GenericCombination<>(4L, 5L));

        check(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(3);

        GenericCombinationList expected = new GenericCombinationList<>()
                .add(new GenericCombination<>(1L, 2L, 3L))
                .add(new GenericCombination<>(1L, 2L, 4L))
                .add(new GenericCombination<>(1L, 2L, 5L))
                .add(new GenericCombination<>(1L, 3L, 4L))
                .add(new GenericCombination<>(1L, 3L, 5L))
                .add(new GenericCombination<>(1L, 4L, 5L))
                .add(new GenericCombination<>(2L, 3L, 4L))
                .add(new GenericCombination<>(2L, 3L, 5L))
                .add(new GenericCombination<>(2L, 4L, 5L))
                .add(new GenericCombination<>(3L, 4L, 5L))
                ;

        check(expected, actual);
    }

    @Test
    public void four_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(4);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>(1L, 2L, 3L, 4L))
                .add(new GenericCombination<>(1L, 2L, 3L, 5L))
                .add(new GenericCombination<>(1L, 2L, 4L, 5L))
                .add(new GenericCombination<>(1L, 3L, 4L, 5L))
                .add(new GenericCombination<>(2L, 3L, 4L, 5L))
                ;

        check(expected, actual);
    }

    @Test
    public void five_theCombinationsOf() {
        GenericCombinationIterator<Long> actual = createActual(5);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>(1L, 2L, 3L, 4L, 5L));

        check(expected, actual);
    }

    private void check(GenericCombinationList<Long> expected,
                       GenericCombinationIterator<Long> actualIterator) {

        GenericCombinationList<Long> actual = new GenericCombinationList<>();

        while (actualIterator.hasNext()) {
            GenericCombination<Long> value = actualIterator.next();
            actual.add(value);
        }

        check(expected, actual);
    }

    private void check(GenericCombinationList<Long> expected,
                       GenericCombinationList<Long> actual) {

        assertEquals(expected, actual);
    }

    private static List<Long> createListOfLong(long... numbers) {
        List<Long> result = new ArrayList<>();

        for (long n : numbers) {
            result.add(n);
        }

        return result;
    }

    private GenericCombinationIterator<Long> createActual(int selectSize) {
        List<Long> input = createListOfLong(1, 2, 3, 4, 5);

        return createGenericCombinationIterator(input, selectSize);
    }
}
