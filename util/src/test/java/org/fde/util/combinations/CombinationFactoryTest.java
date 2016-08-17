package org.fde.util.combinations;

import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationFactory;
import org.fde.util.combinations.CombinationsList;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class CombinationFactoryTest {
    @Test
    public void one_theCombinationsOf() {
        List<Long> input = asList(1L);

        CombinationsList actual = new CombinationFactory(input).getCombinations();

        CombinationsList expected = new CombinationsList().add(new Combination(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        List<Long> input = asList(1L, 2L);

        CombinationsList actual = new CombinationFactory(input).getCombinations();

        CombinationsList expected = new CombinationsList()
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        List<Long> input = asList(1L, 2L, 3L);

        CombinationsList actual = new CombinationFactory(input).getCombinations();

        CombinationsList expected = new CombinationsList()
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
        List<Long> input = asList(1L, 2L, 3L, 4L);

        CombinationsList actual = new CombinationFactory(input).getCombinations();

        CombinationsList expected = new CombinationsList()
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
