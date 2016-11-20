package org.fde.util.combinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericCombinationFactoryTest {
    @Test
    public void one_theCombinationsOf() {
        List<Long> input = createListOfLong(1L);

        GenericCombinationList actual = new GenericCombinationFactory<>(input).getCombinations();

        GenericCombinationList expected = new GenericCombinationList().add(new GenericCombination(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        List<Long> input = createListOfLong(1L, 2L);

        GenericCombinationList actual = new GenericCombinationFactory(input).getCombinations();

        GenericCombinationList expected = new GenericCombinationList()
                .add(new GenericCombination(1L))
                .add(new GenericCombination(2L))
                .add(new GenericCombination(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        List<Long> input = createListOfLong(1L, 2L, 3L);

        GenericCombinationList actual = new GenericCombinationFactory(input).getCombinations();

        GenericCombinationList expected = new GenericCombinationList()
                .add(new GenericCombination(1L))
                .add(new GenericCombination(2L))
                .add(new GenericCombination(3L))
                .add(new GenericCombination(1L, 2L))
                .add(new GenericCombination(1L, 3L))
                .add(new GenericCombination(2L, 3L))
                .add(new GenericCombination(1L, 2L, 3L));

        assertEquals(expected, actual);
    }

    @Test
    public void four_theCombinationsOf() {
        List<Long> input = createListOfLong(1L, 2L, 3L, 4L);

        GenericCombinationList actual = new GenericCombinationFactory(input).getCombinations();

        GenericCombinationList expected = new GenericCombinationList()
                .add(new GenericCombination(1L))
                .add(new GenericCombination(2L))
                .add(new GenericCombination(3L))
                .add(new GenericCombination(4L))
                .add(new GenericCombination(1L, 2L))
                .add(new GenericCombination(1L, 3L))
                .add(new GenericCombination(1L, 4L))
                .add(new GenericCombination(2L, 3L))
                .add(new GenericCombination(2L, 4L))
                .add(new GenericCombination(3L, 4L))
                .add(new GenericCombination(1L, 2L, 3L))
                .add(new GenericCombination(1L, 2L, 4L))
                .add(new GenericCombination(1L, 3L, 4L))
                .add(new GenericCombination(2L, 3L, 4L))
                .add(new GenericCombination(1L, 2L, 3L, 4L)
                );

        assertEquals(expected, actual);
    }

    private static List<Long> createListOfLong(long... numbers) {
        List<Long> result = new ArrayList<Long>();

        for (long n : numbers) {
            result.add(Long.valueOf(n));
        }

        return result;
    }
}
