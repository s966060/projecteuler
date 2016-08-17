package org.fde.util.permutations;

import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationFactory;
import org.fde.util.permutations.PermutationList;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PermutationFactoryTest {
    @Test
    public void one_thePermutationsOf() {
        List<Long> input = asList(1L);

        PermutationList actual = new PermutationFactory(input).getPermutations();

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        List<Long> input = asList(1L, 2L);

        PermutationList actual = new PermutationFactory(input).getPermutations();

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L, 2L))
                .add(new Permutation(2L, 1L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        List<Long> input = asList(1L, 2L, 3L);

        PermutationList actual = new PermutationFactory(input).getPermutations();

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L, 2L, 3L))
                .add(new Permutation(1L, 3L, 2L))
                .add(new Permutation(2L, 1L, 3L))
                .add(new Permutation(2L, 3L, 1L))
                .add(new Permutation(3L, 1L, 2L))
                .add(new Permutation(3L, 2L, 1L));

        assertEquals(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        List<Long> input = asList(1L, 2L, 3L, 4L);

        PermutationList actual = new PermutationFactory(input).getPermutations();

        PermutationList expected = new PermutationList()
                .add(new Permutation(4L, 1L, 2L, 3L))
                .add(new Permutation(4L, 1L, 3L, 2L))
                .add(new Permutation(4L, 2L, 1L, 3L))
                .add(new Permutation(4L, 2L, 3L, 1L))
                .add(new Permutation(4L, 3L, 1L, 2L))
                .add(new Permutation(4L, 3L, 2L, 1L))

                .add(new Permutation(1L, 4L, 2L, 3L))
                .add(new Permutation(1L, 4L, 3L, 2L))
                .add(new Permutation(2L, 4L, 1L, 3L))
                .add(new Permutation(2L, 4L, 3L, 1L))
                .add(new Permutation(3L, 4L, 1L, 2L))
                .add(new Permutation(3L, 4L, 2L, 1L))

                .add(new Permutation(1L, 2L, 4L, 3L))
                .add(new Permutation(1L, 3L, 4L, 2L))
                .add(new Permutation(2L, 1L, 4L, 3L))
                .add(new Permutation(2L, 3L, 4L, 1L))
                .add(new Permutation(3L, 1L, 4L, 2L))
                .add(new Permutation(3L, 2L, 4L, 1L))

                .add(new Permutation(1L, 2L, 3L, 4L))
                .add(new Permutation(1L, 3L, 2L, 4L))
                .add(new Permutation(2L, 1L, 3L, 4L))
                .add(new Permutation(2L, 3L, 1L, 4L))
                .add(new Permutation(3L, 1L, 2L, 4L))
                .add(new Permutation(3L, 2L, 1L, 4L));

        assertEquals(expected, actual);
    }
}
