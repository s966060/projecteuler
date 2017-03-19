package org.fde.util.combinations;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class CombinationFactoryTest {
    @Test
    public void empty_theCombinationsOf() {
        ListOfLong input = createListOfLong();

        CombinationList actual = new CombinationFactory(input).getCombinations();

        CombinationList expected = new CombinationList()
                .add(new Combination());

        assertEquals(expected, actual);
    }

    @Test
    public void one_theCombinationsOf() {
        ListOfLong input = createListOfLong(1L);

        CombinationList actual = new CombinationFactory(input).getCombinations();

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        ListOfLong input = createListOfLong(1L, 2L);

        CombinationList actual = new CombinationFactory(input).getCombinations();

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        ListOfLong input = createListOfLong(1L, 2L, 3L);

        CombinationList actual = new CombinationFactory(input).getCombinations();

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(3L))
                .add(new Combination(1L, 2L))
                .add(new Combination(1L, 3L))
                .add(new Combination(2L, 3L))
                .add(new Combination(1L, 2L, 3L));

        assertEquals(expected, actual);
    }

    @Test
    public void four_theCombinationsOf() {
        ListOfLong input = createListOfLong(1L, 2L, 3L, 4L);

        CombinationList actual = new CombinationFactory(input).getCombinations();

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(3L))
                .add(new Combination(4L))
                .add(new Combination(1L, 2L))
                .add(new Combination(1L, 3L))
                .add(new Combination(1L, 4L))
                .add(new Combination(2L, 3L))
                .add(new Combination(2L, 4L))
                .add(new Combination(3L, 4L))
                .add(new Combination(1L, 2L, 3L))
                .add(new Combination(1L, 2L, 4L))
                .add(new Combination(1L, 3L, 4L))
                .add(new Combination(2L, 3L, 4L))
                .add(new Combination(1L, 2L, 3L, 4L)
                );

        assertEquals(expected, actual);
    }
}
