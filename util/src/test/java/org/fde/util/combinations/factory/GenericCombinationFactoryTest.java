package org.fde.util.combinations.factory;

import org.fde.util.combinations.GenericCombination;
import org.fde.util.combinations.GenericCombinationList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericCombinationFactoryTest {
    @Test
    public void empty_theCombinationsOf() {
        GenericCombinationList<Long> actual = createActual();

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>());

        assertEquals(expected, actual);
    }

    @Test
    public void one_theCombinationsOf() {
        GenericCombinationList<Long> actual = createActual(1);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>())
                .add(new GenericCombination<>(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        GenericCombinationList<Long> actual = createActual(1, 2);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>())
                .add(new GenericCombination<>(1L))
                .add(new GenericCombination<>(2L))
                .add(new GenericCombination<>(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        GenericCombinationList<Long> actual = createActual(1, 2, 3);

        GenericCombinationList expected = new GenericCombinationList<>()
                .add(new GenericCombination<>())
                .add(new GenericCombination<>(1L))
                .add(new GenericCombination<>(2L))
                .add(new GenericCombination<>(3L))
                .add(new GenericCombination<>(1L, 2L))
                .add(new GenericCombination<>(1L, 3L))
                .add(new GenericCombination<>(2L, 3L))
                .add(new GenericCombination<>(1L, 2L, 3L));

        assertEquals(expected, actual);
    }

    @Test
    public void four_theCombinationsOf() {
        GenericCombinationList<Long> actual = createActual(1, 2, 3, 4);

        GenericCombinationList<Long> expected = new GenericCombinationList<Long>()
                .add(new GenericCombination<>())
                .add(new GenericCombination<>(1L))
                .add(new GenericCombination<>(2L))
                .add(new GenericCombination<>(3L))
                .add(new GenericCombination<>(4L))
                .add(new GenericCombination<>(1L, 2L))
                .add(new GenericCombination<>(1L, 3L))
                .add(new GenericCombination<>(1L, 4L))
                .add(new GenericCombination<>(2L, 3L))
                .add(new GenericCombination<>(2L, 4L))
                .add(new GenericCombination<>(3L, 4L))
                .add(new GenericCombination<>(1L, 2L, 3L))
                .add(new GenericCombination<>(1L, 2L, 4L))
                .add(new GenericCombination<>(1L, 3L, 4L))
                .add(new GenericCombination<>(2L, 3L, 4L))
                .add(new GenericCombination<>(1L, 2L, 3L, 4L)
                );

        assertEquals(expected, actual);
    }

    private static List<Long> createListOfLong(long... numbers) {
        List<Long> result = new ArrayList<>();

        for (long n : numbers) {
            result.add(n);
        }

        return result;
    }

    private GenericCombinationList<Long> createActual(long... values) {
        List<Long> input = createListOfLong(values);

        return new GenericCombinationFactory<>(input)
                .getCombinations();
    }
}
