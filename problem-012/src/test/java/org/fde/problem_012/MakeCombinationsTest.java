package org.fde.problem_012;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by filip on 17/08/2016.
 */
public class MakeCombinationsTest {
    @Test
    public void one_theCombinationsOf() {
        List<Long> input = asList(1L);

        CombinationsList actual = new CombinationFactory().getCombinations(input);

        CombinationsList expected = new CombinationsList().add(new Combination(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_theCombinationsOf() {
        List<Long> input = asList(1L, 2L);

        CombinationsList actual = new CombinationFactory().getCombinations(input);

        CombinationsList expected = new CombinationsList()
                .add(new Combination(1L))
                .add(new Combination(2L))
                .add(new Combination(1L, 2L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_theCombinationsOf() {
        List<Long> input = asList(1L, 2L, 3L);

        CombinationsList actual = new CombinationFactory().getCombinations(input);

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
}
