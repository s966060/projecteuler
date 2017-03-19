package org.fde.util.combinations.factory;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class CombinationFactoryTest {
    @Test
    public void empty_theCombinationsOf() {
        CombinationList actual = createActual();

        CombinationList expected = new CombinationList()
                .add(new Combination());

        assertEquals(expected, actual);
    }

    @Test
    public void one_theCombinationsOf() {
        CombinationList actual = createActual(1L);

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        CombinationList actual = createActual(1L, 2L);

        CombinationList expected = new CombinationList()
                .add(new Combination())
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        CombinationList actual = createActual(1L, 2L, 3L);

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
        CombinationList actual = createActual(1L, 2L, 3L, 4L);

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

    private CombinationList createActual(long... values) {
        ListOfLong input = createListOfLong(values);

        return new CombinationFactory(input).getCombinations();
    }
}
